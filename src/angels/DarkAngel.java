package angels;

import abilities.Visitor;
import champions.Knight;
import champions.Pyromancer;
import champions.Rogue;
import champions.Wizard;
import helpers.Constants;


public class DarkAngel extends Angel implements Visitor {
    public final void visit(Knight knight) {
        knight.takeDmg(Constants.DARK_KNIGHT_DMG);
        if (knight.getHp() <= 0) {
            knight.setState("dead");
        }
    }

    public final void visit(Pyromancer pyromancer) {
        pyromancer.takeDmg(Constants.DARK_PYRO_DMG);
        if (pyromancer.getHp() <= 0) {
            pyromancer.setState("dead");
        }
    }

    public final void visit(Rogue rogue) {
        rogue.takeDmg(Constants.DARK_ROGUE_DMG);
        if (rogue.getHp() <= 0) {
            rogue.setState("dead");
        }
    }

    public final void visit(Wizard wizard) {
        wizard.takeDmg(Constants.DARK_WIZARD_DMG);
        if (wizard.getHp() <= 0) {
            wizard.setState("dead");
        }
    }
}
