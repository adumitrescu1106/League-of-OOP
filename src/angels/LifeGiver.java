package angels;

import abilities.Visitor;
import champions.Knight;
import champions.Pyromancer;
import champions.Rogue;
import champions.Wizard;
import helpers.Constants;

public class LifeGiver extends Angel implements Visitor {
    public LifeGiver(final int x, final int y) {
        super(x, y);
        this.setType("LifeGiver");
    }

    public final void visit(final Knight knight) {
        knight.heal(Constants.LIFE_KNIGHT_DMG);
        if (knight.getHp() >= (Constants.KNIGHT_HP + knight.getLevel() * Constants.KNIGHT_HP_UP)) {
            knight.setHp(Constants.KNIGHT_HP + knight.getLevel() * Constants.KNIGHT_HP_UP);
        }
    }

    public final void visit(final Pyromancer pyromancer) {
        pyromancer.heal(Constants.LIFE_PYRO_DMG);
        if (pyromancer.getHp() >= (Constants.PYROMANCER_HP + pyromancer.getLevel()
                * Constants.PYROMANCER_HP_UP)) {
            pyromancer.setHp(Constants.PYROMANCER_HP + pyromancer.getLevel()
                    * Constants.PYROMANCER_HP_UP);
        }
    }

    public final void visit(final Rogue rogue) {
        rogue.heal(Constants.LIFE_ROGUE_DMG);
        if (rogue.getHp() >= (Constants.ROGUE_HP + rogue.getLevel() * Constants.ROGUE_HP_UP)) {
            rogue.setHp(Constants.ROGUE_HP + rogue.getLevel() * Constants.ROGUE_HP_UP);
        }
    }

    public final void visit(final Wizard wizard) {
        wizard.heal(Constants.LIFE_WIZARD_DMG);
        if (wizard.getHp() >= (Constants.WIZARD_HP + wizard.getLevel() * Constants.WIZARD_HP_UP)) {
            wizard.setHp(Constants.WIZARD_HP + wizard.getLevel() * Constants.WIZARD_HP_UP);
        }
    }
}
