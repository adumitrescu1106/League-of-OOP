package angels;

import abilities.Visitor;
import champions.Knight;
import champions.Pyromancer;
import champions.Rogue;
import champions.Wizard;
import helpers.Constants;

public class XPAngel extends Angel implements Visitor {
    public XPAngel(int x, int y) {
        super(x, y);
        this.setType("XPAngel");
    }

    public final void visit(Knight knight) {
        knight.addXp(Constants.XP_KNIGHT);
        int level = knight.getLevel();
        knight.setLevel((knight.getXp() - Constants.EXPERIENCE) / Constants.FRACTION_EXP);
        if (knight.getLevel() > level) {
            knight.levelUp();
        }
    }

    public final void visit(Pyromancer pyromancer) {
        pyromancer.addXp(Constants.XP_PYRO);
        int level = pyromancer.getLevel();
        pyromancer.setLevel((pyromancer.getXp() - Constants.EXPERIENCE) / Constants.FRACTION_EXP);
        if (pyromancer.getLevel() > level) {
            pyromancer.levelUp();
        }
    }

    public final void visit(Rogue rogue) {
        rogue.addXp(Constants.XP_ROGUE);
        int level = rogue.getLevel();
        rogue.setLevel((rogue.getXp() - Constants.EXPERIENCE) / Constants.FRACTION_EXP);
        if (rogue.getLevel() > level) {
            rogue.levelUp();
        }
    }

    public final void visit(Wizard wizard) {
        wizard.addXp(Constants.XP_WIZARD);
        int level = wizard.getLevel();
        wizard.setLevel((wizard.getXp() - Constants.EXPERIENCE) / Constants.FRACTION_EXP);
        if (wizard.getLevel() > level) {
            wizard.levelUp();
        }
    }
}
