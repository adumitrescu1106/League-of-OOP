package angels;

import abilities.Visitor;
import champions.Knight;
import champions.Pyromancer;
import champions.Rogue;
import champions.Wizard;
import helpers.Constants;

public class XPAngel extends Angel implements Visitor {
    public XPAngel(final int x, final int y) {
        super(x, y);
        this.setType("XPAngel");
    }

    public final void visit(final Knight knight) {
        knight.addXp(Constants.XP_KNIGHT);
        int level = knight.getLevel();
        knight.setLevel((knight.getXp() - Constants.EXPERIENCE) / Constants.FRACTION_EXP);
        if (knight.getLevel() > level) {
            knight.levelUp();
        } else {
            knight.setLevel(level);
        }
    }

    public final void visit(final Pyromancer pyromancer) {
        pyromancer.addXp(Constants.XP_PYRO);
        int level = pyromancer.getLevel();
        pyromancer.setLevel((pyromancer.getXp() - Constants.EXPERIENCE) / Constants.FRACTION_EXP);
        if (pyromancer.getLevel() > level) {
            pyromancer.levelUp();
        } else {
            pyromancer.setLevel(level);
        }
    }

    public final void visit(final Rogue rogue) {
        rogue.addXp(Constants.XP_ROGUE);
        int level = rogue.getLevel();
        rogue.setLevel((rogue.getXp() - Constants.EXPERIENCE) / Constants.FRACTION_EXP);
        if (rogue.getLevel() > level) {
            rogue.levelUp();
        } else {
            rogue.setLevel(level);
        }
    }

    public final void visit(final Wizard wizard) {
        wizard.addXp(Constants.XP_WIZARD);
        int level = wizard.getLevel();
        wizard.setLevel((wizard.getXp() - Constants.EXPERIENCE) / Constants.FRACTION_EXP);
        if (wizard.getLevel() > level) {
            wizard.levelUp();
        } else {
            wizard.setLevel(level);
        }
    }
}
