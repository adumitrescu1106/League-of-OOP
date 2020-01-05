package angels;

import abilities.Visitor;
import champions.Knight;
import champions.Pyromancer;
import champions.Rogue;
import champions.Wizard;
import helpers.Constants;

public class GoodBoy extends Angel implements Visitor {
    public GoodBoy(int x, int y) {
        super(x, y);
        this.setType("GoodBoy");
    }

    public final void visit(Knight knight) {
        knight.increaseAll(Constants.GOODBOY_K);
        knight.heal(Constants.GOODBOY_KNIGHT_HEAL);
        if (knight.getHp() > (Constants.KNIGHT_HP + knight.getLevel() * Constants.KNIGHT_HP_UP)) {
            knight.setHp(Constants.KNIGHT_HP + knight.getLevel() * Constants.KNIGHT_HP_UP);
        }
    }

    public final void visit(Pyromancer pyromancer) {
        pyromancer.increaseAll(Constants.GOODBOY_P);
        pyromancer.heal(Constants.GOODBOY_PYRO_HEAL);
        if (pyromancer.getHp() > (Constants.PYROMANCER_HP + pyromancer.getLevel()
                * Constants.KNIGHT_HP_UP)) {
            pyromancer.setHp(Constants.PYROMANCER_HP + pyromancer.getLevel()
                    * Constants.PYROMANCER_HP_UP);
        }
    }

    public final void visit(Rogue rogue) {
        rogue.increaseAll(Constants.GOODBOY_R);
        rogue.heal(Constants.GOODBOY_ROGUE_HEAL);
        if (rogue.getHp() > (Constants.ROGUE_HP + rogue.getLevel() * Constants.ROGUE_HP_UP)) {
            rogue.setHp(Constants.ROGUE_HP + rogue.getLevel() * Constants.ROGUE_HP_UP);
        }
    }

    public final void visit(Wizard wizard) {
        wizard.increaseAll(Constants.GOODBOY_W);
        wizard.heal(Constants.GOODBOY_WIZARD_HEAL);
        if (wizard.getHp() > (Constants.WIZARD_HP + wizard.getLevel() * Constants.WIZARD_HP_UP)) {
            wizard.setHp(Constants.WIZARD_HP + wizard.getLevel() * Constants.WIZARD_HP_UP);
        }
    }
}
