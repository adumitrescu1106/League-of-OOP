package angels;

import abilities.Visitor;
import champions.Knight;
import champions.Pyromancer;
import champions.Rogue;
import champions.Wizard;
import helpers.Constants;

public class SmallAngel extends Angel implements Visitor {
    public SmallAngel(final int x, final int y) {
        super(x, y);
        this.setType("SmallAngel");
    }

    public final void visit(final Knight knight) {
        knight.increaseAll(Constants.SMALLANGEL_K);
        knight.heal(Constants.SMALLANGEL_KNIGHT_HEAL);
        if (knight.getHp() > (Constants.KNIGHT_HP + knight.getLevel() * Constants.KNIGHT_HP_UP)) {
            knight.setHp(Constants.KNIGHT_HP + knight.getLevel() * Constants.KNIGHT_HP_UP);
        }
    }

    public final void visit(final Pyromancer pyromancer) {
        pyromancer.increaseAll(Constants.SMALLANGEL_P);
        pyromancer.heal(Constants.SMALLANGEL_PYRO_HEAL);
        if (pyromancer.getHp() > (Constants.PYROMANCER_HP + pyromancer.getLevel()
                * Constants.KNIGHT_HP_UP)) {
            pyromancer.setHp(Constants.PYROMANCER_HP + pyromancer.getLevel()
                    * Constants.PYROMANCER_HP_UP);
        }
    }

    public final void visit(final Rogue rogue) {
        rogue.increaseAll(Constants.SMALLANGEL_R);
        rogue.heal(Constants.SMALLANGEL_ROGUE_HEAL);
        if (rogue.getHp() > (Constants.ROGUE_HP + rogue.getLevel() * Constants.ROGUE_HP_UP)) {
            rogue.setHp(Constants.ROGUE_HP + rogue.getLevel() * Constants.ROGUE_HP_UP);
        }
    }

    public final void visit(final Wizard wizard) {
        wizard.increaseAll(Constants.SMALLANGEL_W);
        wizard.heal(Constants.SMALLANGEL_WIZARD_HEAL);
        if (wizard.getHp() > (Constants.WIZARD_HP + wizard.getLevel() * Constants.WIZARD_HP_UP)) {
            wizard.setHp(Constants.WIZARD_HP + wizard.getLevel() * Constants.WIZARD_HP_UP);
        }
    }
}
