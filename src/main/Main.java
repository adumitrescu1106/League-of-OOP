package main;

import abilities.Ability;
import champions.Champion;
import fileio.FileSystem;
import helpers.Constants;

import java.io.IOException;
import java.util.ArrayList;

public final class Main {

    private Main() {
        // doar pentru pacalirea checkstyle-ului
    }

    public static void main(final String[] args) throws IOException {
        // Realizez initializarea inputului
        GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
        GameInput gameInput = gameInputLoader.load();
        int rounds = gameInput.getRounds();
        ArrayList<ArrayList<Character>> arena = gameInput.getArena();
        ArrayList<ArrayList<Character>> moves = gameInput.getMoves();
        ArrayList<Champion> players = gameInput.getPlayers();
        ArrayList<ArrayList<Ability>> spells = gameInput.getSpells();

        // Desfasurarea jocului
        for (int i = 0; i < rounds; ++i) {
            // miscarea pe harta
            for (int j = 0; j < players.size(); ++j) {
                // in funtie de ce miscare trebuie sa faca, se realizeaza modificarile
                // daca nu este paralizat, se misca
                if (players.get(j).getParalysis() <= 0) {
                    if (moves.get(i).get(j).equals('U')) {
                        players.get(j).setxPosition(players.get(j).getxPosition() - 1);
                        // se updateaza tipul de teren pe care se afla, dupa ce se misca
                        players.get(j).setPosition(arena.get(players.get(j).getxPosition())
                                .get(players.get(j).getyPosition()));
                    } else if (moves.get(i).get(j).equals('D')) {
                        players.get(j).setxPosition(players.get(j).getxPosition() + 1);
                        players.get(j).setPosition(arena.get(players.get(j).getxPosition())
                                .get(players.get(j).getyPosition()));
                    } else if (moves.get(i).get(j).equals('L')) {
                        players.get(j).setyPosition(players.get(j).getyPosition() - 1);
                        players.get(j).setPosition(arena.get(players.get(j).getxPosition())
                                .get(players.get(j).getyPosition()));
                    } else if (moves.get(i).get(j).equals('R')) {
                        players.get(j).setyPosition(players.get(j).getyPosition() + 1);
                        players.get(j).setPosition(arena.get(players.get(j).getxPosition())
                                .get(players.get(j).getyPosition()));
                    }
                }
                // se scade durata paraliziei
                players.get(j).setParalysis(players.get(j).getParalysis() - 1);
            }
            // se da damage-ul overtime, daca exista
            for (Champion player : players) {
                if (player.getOvertimeType().equals("ignite") && player.getOvertimeDuration()
                        < Constants.IGNITE_ROUNDS && player.getOvertimeDuration() > 0) {
                    player.takeDmg(player.getOvertimeDmg());
                }
                if (player.getOvertimeType().equals("paralysis") && player.getOvertimeDuration()
                        < Constants.PARALYSIS_ROUNDS && player.getOvertimeDuration() >= 0) {
                    player.takeDmg(player.getOvertimeDmg());
                }
                if (player.getOvertimeType().equals("paralysis_extra")
                        && player.getOvertimeDuration()
                        < Constants.PARALYSIS_EXTRA && player.getOvertimeDuration() >= 0) {
                    player.takeDmg(player.getOvertimeDmg());
                }
                // daca playerul moare dupa un efect overtime, se updateaza starea lui
                if (player.getHp() <= 0) {
                    player.setState("dead");
                }
            }
            for (int j = 0; j < players.size() - 1; j++) {
                for (int k = j + 1; k < players.size(); k++) {
                    if (players.get(j).getState().equals("alive")
                            && players.get(k).getState().equals("alive")
                    && players.get(j).isFight() && players.get(k).isFight()
                    && players.get(j).getxPosition() == players.get(k).getxPosition()
                    && players.get(j).getyPosition() == players.get(k).getyPosition()) {
                        if (players.get(j).getType().equals("W")
                                && players.get(k).getType().equals("W")) {
                            // tratez cazul in care sunt amandoi wizard ca pe unul normal
                            battle(players.get(j), j, players.get(k), k, spells);
                            giveXpIfnecessary(players.get(j), j, players.get(k), k, spells);
                        } else if (players.get(j).getType().equals("W")) {
                            // daca wizardul este primul (pentru deflect),
                            // isi da al doilea abilitatile
                            wizardBattle(players.get(j), j, players.get(k), k, spells);
                            giveXpIfnecessary(players.get(j), j, players.get(k), k, spells);
                        } else if (players.get(k).getType().equals("W")) {
                            // daca wizardul este al doilea (pentru deflect) , se pastreaza ordinea
                            wizardBattle(players.get(k), k, players.get(j), j, spells);
                            giveXpIfnecessary(players.get(j), j, players.get(k), k, spells);
                        } else {
                            battle(players.get(j), j, players.get(k), k, spells);
                            giveXpIfnecessary(players.get(j), j, players.get(k), k, spells);
                        }
                    }
                }
            }
            // decrementez durata efectelor overtime
            for (Champion player : players) {
                player.setOvertimeDuration(player.getOvertimeDuration() - 1);
                player.setFight(true);
            }
        }
        // Printez in fisier datele despre jucatori
        FileSystem fs = new FileSystem(args[0], args[1]);
        print(players, fs);
    }

    // functia de printare a datelor jucatorilor
    private static void print(final ArrayList<Champion> players, final FileSystem fs)
            throws IOException {
        for (Champion player : players) {
            if (player.getHp() <= 0) {
                fs.writeWord(player.getType());
                fs.writeWord(" dead");
                fs.writeNewLine();
            } else {
                fs.writeWord(player.getType());
                fs.writeWord(" ");
                fs.writeInt(player.getLevel());
                fs.writeWord(" ");
                fs.writeInt(player.getXp());
                fs.writeWord(" ");
                fs.writeInt(player.getHp());
                fs.writeWord(" ");
                fs.writeInt(player.getxPosition());
                fs.writeWord(" ");
                fs.writeInt(player.getyPosition());
                fs.writeNewLine();
            }
        }
        fs.close();
    }
    // functie care da experienta jucatorului care si-a omorat adversarul
    private static void giveXpIfnecessary(final Champion champion, final int j,
                                          final Champion secondChampion, final int k,
                                          final ArrayList<ArrayList<Ability>> spells) {
        if (champion.getState().equals("alive") && secondChampion.getState().equals("dead")) {
            int level = champion.getLevel();
            champion.addXp(Math.max(0, Constants.EXPERIENCE - (champion.getLevel()
                    - secondChampion.getLevel()) * Constants.SMALL_EXPERIENCE));
            champion.setLevel((champion.getXp() - Constants.EXPERIENCE) / Constants.FRACTION_EXP);
            //level up daca au xp ul necesar
            if (champion.getLevel() > level) {
                // level up campionului
                champion.levelUp();
                // level up abilitatilor campionului
                for (int i = 0; i < (champion.getLevel() - level); ++i) {
                    spells.get(j).get(0).levelUP();
                    spells.get(j).get(1).levelUP();
                }
            }
        } else if (champion.getState().equals("dead")
                && secondChampion.getState().equals("alive")) {
            int level = secondChampion.getLevel();
            secondChampion.addXp(Math.max(0, Constants.EXPERIENCE - (secondChampion.getLevel()
                    - champion.getLevel()) * Constants.SMALL_EXPERIENCE));
            secondChampion.setLevel((secondChampion.getXp() - Constants.EXPERIENCE)
                    / Constants.FRACTION_EXP);
            if (secondChampion.getLevel() > level) {
                secondChampion.levelUp();
                for (int i = 0; i < (secondChampion.getLevel() - level); ++i) {
                    spells.get(k).get(0).levelUP();
                    spells.get(k).get(1).levelUP();
                }
            }
        }
    }

    // functia care trateaza cazul in care unul dintre jucatori este wizard
    //(pentru deflect)
    private static void wizardBattle(final Champion wizard, final int j,
                                     final Champion enemy, final int k,
                                     final ArrayList<ArrayList<Ability>> spells) {
        //mai intai wizardul este afectat de abilitatile inamicului
        // pentru calcularea efectului deflectului
        wizard.accept(spells.get(k).get(0));
        wizard.accept(spells.get(k).get(1));
        enemy.setDamageDeflect(wizard.getDamageDeflect());
        enemy.accept(spells.get(j).get(0));
        enemy.accept(spells.get(j).get(1));
        wizard.resetdamageDeflect();
        enemy.resetdamageDeflect();
        // se verifica cine a murit dupa ce au fost date spellurile
        if (wizard.getHp() <= 0) {
            wizard.setState("dead");
        }
        if (enemy.getHp() <= 0) {
            enemy.setState("dead");
        }
        // setez indicele care arata ca cei 2 jucatori au luptat runda asta
        wizard.setFight(false);
        enemy.setFight(false);
    }

    // functia care efectueaza lupta dintre 2 jucatori
    private static void battle(final Champion champion, final int j,
                               final Champion secondchampion, final int k,
                               final ArrayList<ArrayList<Ability>> spells) {
        secondchampion.accept(spells.get(j).get(0));
        secondchampion.accept(spells.get(j).get(1));
        champion.accept(spells.get(k).get(0));
        champion.accept(spells.get(k).get(1));
        // se verifica cine a murit dupa ce au fost date spellurile
        if (champion.getHp() <= 0) {
            champion.setState("dead");
        }
        if (secondchampion.getHp() <= 0) {
            secondchampion.setState("dead");
        }
        // setez indicele care arata ca cei 2 jucatori au luptat runda asta
        champion.setFight(false);
        secondchampion.setFight(false);
    }
}
