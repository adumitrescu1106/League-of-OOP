package angels;

import abilities.Visitor;
import champions.Knight;
import champions.Pyromancer;
import champions.Rogue;
import champions.Wizard;
import helpers.Constants;

public class Dracula extends Angel implements Visitor {
    public Dracula(final int x, final int y) {
        super(x, y);
        this.setType("Dracula");
    }

    public final void visit(final Knight knight) {
        knight.decreaseAll(Constants.DRACULA_K);
        knight.takeDmg(Constants.DRACULA_KNIGHT_DMG);
        if (knight.getHp() <= 0) {
            knight.setState("dead");
        }
    }

    public final void visit(final Pyromancer pyromancer) {
        pyromancer.decreaseAll(Constants.DRACULA_P);
        pyromancer.takeDmg(Constants.DRACULA_PYRO_DMG);
        if (pyromancer.getHp() <= 0) {
            pyromancer.setState("dead");
        }
    }

    public final void visit(final Rogue rogue) {
        rogue.decreaseAll(Constants.DRACULA_R);
        rogue.takeDmg(Constants.DRACULA_ROGUE_DMG);
        if (rogue.getHp() <= 0) {
            rogue.setState("dead");
        }
    }

    public final void visit(final Wizard wizard) {
        wizard.decreaseAll(Constants.DRACULA_W);
        wizard.takeDmg(Constants.DRACULA_WIZARD_DMG);
        if (wizard.getHp() <= 0) {
            wizard.setState("dead");
        }
    }
}
