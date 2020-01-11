package main;

import abilities.Ability;
import angels.Angel;
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
//        String input = "/home/andrei/Documents/TemaPOO-Etapa2/src/checker/resources/in/dense.in";
//        String output = "/home/andrei/Documents/TemaPOO-Etapa2/src/checker/resources/out/dense.out";
//        GameInputLoader gameInputLoader = new GameInputLoader(input, output);
        GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
        GameInput gameInput = gameInputLoader.load();

        int rounds = gameInput.getRounds();
        ArrayList<ArrayList<Character>> arena = gameInput.getArena();
        ArrayList<ArrayList<Character>> moves = gameInput.getMoves();
        ArrayList<Champion> players = gameInput.getPlayers();
        ArrayList<ArrayList<Ability>> spells = gameInput.getSpells();
        ArrayList<ArrayList<Angel>> angels = gameInput.getAngels();
        int level;

//        for (Champion player : players) {
//            System.out.println(player);
//        }
//        for (ArrayList<Angel> angel : angels) {
//            System.out.println(angel);
//        }
         FileSystem fs = new FileSystem(args[0], args[1]);
//        FileSystem fs = new FileSystem(input, output);

        // Desfasurarea jocului
        for (int i = 0; i < rounds; ++i) {
            printRound(i, fs);
            // miscarea pe harta
            for (int j = 0; j < players.size(); ++j) {
                // in funtie de ce miscare trebuie sa faca, se realizeaza modificarile
                // daca nu este paralizat, se misca
                if (players.get(j).getParalysis() <= 0) {
                    if (moves.get(i).get(j).equals('U') && players.get(j).getxPosition() > 0) {
                        players.get(j).setxPosition(players.get(j).getxPosition() - 1);
                        // se updateaza tipul de teren pe care se afla, dupa ce se misca
                        players.get(j).setPosition(arena.get(players.get(j).getxPosition())
                                .get(players.get(j).getyPosition()));
                    } else if (moves.get(i).get(j).equals('D') && players.get(j).getxPosition() < arena.get(0).size()) {
                        players.get(j).setxPosition(players.get(j).getxPosition() + 1);
                        players.get(j).setPosition(arena.get(players.get(j).getxPosition())
                                .get(players.get(j).getyPosition()));
                    } else if (moves.get(i).get(j).equals('L') && players.get(j).getyPosition() > 0) {
                        players.get(j).setyPosition(players.get(j).getyPosition() - 1);
                        players.get(j).setPosition(arena.get(players.get(j).getxPosition())
                                .get(players.get(j).getyPosition()));
                    } else if (moves.get(i).get(j).equals('R') && players.get(j).getyPosition() < arena.size()) {
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
            // fiecare jucator isi stabileste strategia
            for (int j = 0; j < players.size(); ++j) {
                if (players.get(j).getState().equals("alive") && players.get(j).getParalysis() < 0) {
                    players.get(j).playStyle();
                    adjustModifiers(players.get(j), spells.get(j));
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
                            giveXpIfnecessary(players.get(j), j, players.get(k), k, spells, fs);
                        } else if (players.get(j).getType().equals("W")) {
                            // daca wizardul este primul (pentru deflect),
                            // isi da al doilea abilitatile
                            wizardBattle(players.get(j), j, players.get(k), k, spells);
                            giveXpIfnecessary(players.get(j), j, players.get(k), k, spells, fs);
                        } else if (players.get(k).getType().equals("W")) {
                            // daca wizardul este al doilea (pentru deflect) , se pastreaza ordinea
                            wizardBattle(players.get(k), k, players.get(j), j, spells);
                            giveXpIfnecessary(players.get(j), j, players.get(k), k, spells, fs);
                        } else {
                            battle(players.get(j), j, players.get(k), k, spells);
                            giveXpIfnecessary(players.get(j), j, players.get(k), k, spells, fs);
                        }
                    }
                }
            }
            // Efectul ingerilor
            for (int j = 0; j < angels.get(i).size(); ++j) {
                if (angels.get(i).get(j) != null) {
                    printAngel(angels.get(i).get(j), fs);
                    for (int k = 0; k < players.size(); ++k) {
                        level = players.get(k).getLevel();
                        if (players.get(k).getxPosition() == angels.get(i).get(j).getxPosition()
                        && players.get(k).getyPosition() == angels.get(i).get(j).getyPosition()) {
                            if (players.get(k).getState().equals("alive")) {
                                if (!angels.get(i).get(j).getType().equals("Spawner")) {
                                    players.get(k).accept(angels.get(i).get(j));
                                    printAngelHelp(angels.get(i).get(j), players.get(k), k, fs);

                                    if (angels.get(i).get(j).getType().equals("LevelUpAngel")) {
                                        levelUpAbilityAngel(k, spells);
                                        // printLevelUp(players.get(k), fs, k, players.get(k).getLevel());
                                    }
                                    adjustModifiers(players.get(k), spells.get(k));
                                }
                            } else if (players.get(k).getState().equals("dead")
                                    && angels.get(i).get(j).getType().equals("Spawner")) {
                                printAngelHelp(angels.get(i).get(j), players.get(k), k, fs);
                                players.get(k).accept(angels.get(i).get(j));
                            }
                        }

                        if (players.get(k).getLevel() != level) {
                            for (int l = level + 1; l <=  players.get(k).getLevel(); l++) {
                                printLevelUp(players.get(k), fs, k, l);
                            }
                           // printLevelUp(players.get(k), fs, k, players.get(k).getLevel());
                        }
                    }
                }
            }
            // decrementez durata efectelor overtime
            for (Champion player : players) {
                //System.out.println(player.getXp());
                //System.out.println(player.getHp());
                player.setOvertimeDuration(player.getOvertimeDuration() - 1);
                player.setFight(true);
            }
            fs.writeNewLine();
//            print(players, fs);
        }
        // Printez in fisier datele despre jucatori
        print(players, fs);
//        fs.close();
    }

    private static void adjustModifiers(Champion champion, ArrayList<Ability> abilities) {
        abilities.get(0).setKnightModifier(champion.getkFirstModifier());
        abilities.get(0).setPyroModifier(champion.getpFirstModifier());
        abilities.get(0).setRogueModifier(champion.getrFirstModifier());
        abilities.get(0).setWizardModifier(champion.getwFirstModifier());
        abilities.get(1).setKnightModifier(champion.getkSecondModifier());
        abilities.get(1).setPyroModifier(champion.getpSecondModifier());
        abilities.get(1).setRogueModifier(champion.getrSecondModifier());
        abilities.get(1).setWizardModifier(champion.getwSecondModifier());
    }

    // functia de printare a datelor jucatorilor
    private static void print(final ArrayList<Champion> players, final FileSystem fs)
            throws IOException {
        fs.writeWord("~~ Results ~~" + "\n");
        for (Champion player : players) {
            if (player.getState().equals("dead")) {
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

    private static void printRound(final int round, final FileSystem fs)
            throws IOException {
        fs.writeWord("~~ Round " + (round + 1) + " ~~" + "\n");
    }

    private static void printAngel(final Angel angel, final FileSystem fs)
            throws IOException {
            fs.writeWord("Angel " + angel.getType() + " was spawned at "
                    + angel.getxPosition() + " " + angel.getyPosition() + "\n");
    }

    private static void printAngelHelp(final Angel angel, final Champion player,
                                       final int index, final FileSystem fs)
            throws IOException {
        if (angel.getType().equals("TheDoomer") || angel.getType().equals("Dracula") || angel.getType().equals("DarkAngel")) {
            fs.writeWord(angel.getType() + " hit "
                    + player.getLongType() + " " + index + "\n");
            if (player.getState().equals("dead")) {
                fs.writeWord("Player " + player.getLongType() + " " + index + " was killed by an angel" + "\n");
            }
        } else {
            fs.writeWord(angel.getType() + " helped "
                    + player.getLongType() + " " + index + "\n");
            if (angel.getType().equals("Spawner")) {
                fs.writeWord("Player " + player.getLongType() + " " + index + " was brought to life by an angel" + "\n");
            }
        }
    }

    private static void printLevelUp(final Champion champion, final FileSystem fs, final int index, final int level)
            throws IOException {
        fs.writeWord(champion.getLongType() + " " + index + " reached level " + level + "\n");
    }


    private static void levelUpAbilityAngel(final int index, final ArrayList<ArrayList<Ability>> spells) {
        spells.get(index).get(0).levelUP();
        spells.get(index).get(1).levelUP();
    }

    // functie care da experienta jucatorului care si-a omorat adversarul
    private static void giveXpIfnecessary(final Champion champion, final int j,
                                          final Champion secondChampion, final int k,
                                          final ArrayList<ArrayList<Ability>> spells, final FileSystem fs) throws IOException {
        if (champion.getState().equals("alive") && secondChampion.getState().equals("dead")) {
            fs.writeWord("Player " + secondChampion.getLongType() + " " + k + " was killed by "
                    + champion.getLongType() + " " + j + "\n");
            int level = champion.getLevel();
            champion.addXp(Math.max(0, Constants.EXPERIENCE - (champion.getLevel()
                    - secondChampion.getLevel()) * Constants.SMALL_EXPERIENCE));
            champion.setLevel((champion.getXp() - Constants.EXPERIENCE) / Constants.FRACTION_EXP);
            //level up daca au xp ul necesar
            if (champion.getLevel() > level) {
                // level up campionului
                champion.levelUp();
                for (int i = level + 1; i <= champion.getLevel(); i++) {
                    printLevelUp(champion, fs, j, i);
                }
                // level up abilitatilor campionului
                for (int i = 0; i < (champion.getLevel() - level); ++i) {
                    spells.get(j).get(0).levelUP();
                    spells.get(j).get(1).levelUP();
                }
            }
        } else if (champion.getState().equals("dead")
                && secondChampion.getState().equals("alive")) {
            fs.writeWord("Player " + champion.getLongType() + " " + j + " was killed by "
                    + secondChampion.getLongType() + " " + k + "\n");
            int level = secondChampion.getLevel();
            secondChampion.addXp(Math.max(0, Constants.EXPERIENCE - (secondChampion.getLevel()
                    - champion.getLevel()) * Constants.SMALL_EXPERIENCE));
            secondChampion.setLevel((secondChampion.getXp() - Constants.EXPERIENCE)
                    / Constants.FRACTION_EXP);
            if (secondChampion.getLevel() > level) {
                secondChampion.levelUp();
                for (int i = level + 1; i <= secondChampion.getLevel(); i++) {
                    printLevelUp(secondChampion, fs, k, i);
                }
                for (int i = 0; i < (secondChampion.getLevel() - level); ++i) {
                    spells.get(k).get(0).levelUP();
                    spells.get(k).get(1).levelUP();
                }
            }
        } else if (champion.getState().equals("dead")
                && secondChampion.getState().equals("dead")) {
            //System.out.println("aici");
            fs.writeWord("Player " + secondChampion.getLongType() + " " + k + " was killed by "
                    + champion.getLongType() + " " + j + "\n");
            fs.writeWord("Player " + champion.getLongType() + " " + j + " was killed by "
                    + secondChampion.getLongType() + " " + k + "\n");
            int level = champion.getLevel();
            champion.addXp(Math.max(0, Constants.EXPERIENCE - (champion.getLevel()
                    - secondChampion.getLevel()) * Constants.SMALL_EXPERIENCE));
            champion.setLevel((champion.getXp() - Constants.EXPERIENCE) / Constants.FRACTION_EXP);
           // System.out.println("primul" + champion.getXp());
            //level up daca au xp ul necesar
            if (champion.getLevel() > level) {
                // level up campionului
                champion.levelUp();
                for (int i = level + 1; i <= champion.getLevel(); i++) {
                    printLevelUp(champion, fs, j, i);
                }
                // level up abilitatilor campionului
                for (int i = 0; i < (champion.getLevel() - level); ++i) {
                    spells.get(j).get(0).levelUP();
                    spells.get(j).get(1).levelUP();
                }
            }
            secondChampion.addXp(Math.max(0, Constants.EXPERIENCE - (secondChampion.getLevel()
                    - level) * Constants.SMALL_EXPERIENCE));
            level = secondChampion.getLevel();
            secondChampion.setLevel((secondChampion.getXp() - Constants.EXPERIENCE)
                    / Constants.FRACTION_EXP);
            //System.out.println("al doilea " + secondChampion.getXp());
            if (secondChampion.getLevel() > level) {
                secondChampion.levelUp();
                for (int i = level + 1; i <= secondChampion.getLevel(); i++) {
                    printLevelUp(secondChampion, fs, k, i);
                }
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
