package abilities;

import champions.Knight;
import champions.Pyromancer;
import champions.Rogue;
import champions.Wizard;
import helpers.Constants;

public class Execute extends Ability implements Visitor {
    private int executeDmg;
    private int level;

    public Execute() {
        this.executeDmg = Constants.EXECUTE_DMG;
        this.level = 0;
    }

    public final void visit(final Knight knight) {
        // se verifica daca inamicul indeplineste conditia de kill in urma execute-ului
        if (knight.getHp() < Math.round((Constants.KNIGHT_HP + knight.getLevel()
                * Constants.KNIGHT_HP_UP)
                * (Constants.EXECUTE_KILL + Constants.EXECUTE_KILL_ADD * this.getLevel()))) {
            knight.setHp(0);
            // altfel se da damage-ul cu sau fara modificatori
        } else if (knight.getPosition().equals('L')) {
            knight.takeDmg(Math.round(executeDmg * Constants.KNIGHT_LAND));
        } else {
            knight.takeDmg(executeDmg);
        }
    }

    @Override
    public final void visit(final Pyromancer pyromancer) {
        if (pyromancer.getHp() <= Math.round((Constants.PYROMANCER_HP
                + pyromancer.getLevel() * Constants.PYROMANCER_HP_UP)
                * (Constants.EXECUTE_KILL + Constants.EXECUTE_KILL_ADD * this.getLevel()))) {
            pyromancer.setHp(0);
        } else if (pyromancer.getPosition().equals('L')) {
            pyromancer.takeDmg(Math.round(executeDmg
                    * Constants.EXECUTE_PYRO * Constants.KNIGHT_LAND));
        } else {
            pyromancer.takeDmg(Math.round(executeDmg * Constants.EXECUTE_PYRO));
        }
    }

    @Override
    public final void visit(final Rogue rogue) {
        if (rogue.getHp() <= Math.round((Constants.ROGUE_HP
                + rogue.getLevel() * Constants.ROGUE_HP_UP)
                * (Constants.EXECUTE_KILL + Constants.EXECUTE_KILL_ADD * this.getLevel()))) {
            rogue.setHp(0);
        } else if (rogue.getPosition().equals('L')) {
            rogue.takeDmg(Math.round(executeDmg * Constants.EXECUTE_ROGUE * Constants.KNIGHT_LAND));
        } else {
            rogue.takeDmg(Math.round(executeDmg * Constants.EXECUTE_ROGUE));
        }
    }

    @Override
    public final void visit(final Wizard wizard) {
        if (wizard.getHp() <= Math.round((Constants.WIZARD_HP
                + wizard.getLevel() * Constants.WIZARD_HP_UP)
                * (Constants.EXECUTE_KILL + Constants.EXECUTE_KILL_ADD * this.getLevel()))) {
            wizard.setHp(0);
        } else if (wizard.getPosition().equals('L')) {
            wizard.takeDmg(Math.round(executeDmg * Constants.EXECUTE_WIZARD
                    * Constants.KNIGHT_LAND));
            //pentru deflect
            wizard.addDamageDeflect(Math.round(executeDmg * Constants.KNIGHT_LAND));
        } else {
            wizard.takeDmg(Math.round(executeDmg * Constants.EXECUTE_WIZARD));
            //pentru deflect
            wizard.addDamageDeflect(Math.round(executeDmg));
        }
    }

    // se imbunatatesc abilitatile daca nivelul eroului se schimba
    public final void levelUP() {
        setExecuteDmg(getExecuteDmg() + Constants.EXECUTE_UP);
        // variabila level este folosita in calcularea posibilitatii de kill prin execute
        level++;
    }
    public final int getExecuteDmg() {
        return executeDmg;
    }

    public final void setExecuteDmg(final int executeDmg) {
        this.executeDmg = executeDmg;
    }

    public final int getLevel() {
        return level;
    }

    public final void setLevel(final int level) {
        this.level = level;
    }
}
