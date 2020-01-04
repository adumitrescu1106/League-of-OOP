package angels;

import abilities.Visitor;
import champions.Knight;
import champions.Pyromancer;
import champions.Rogue;
import champions.Wizard;
import helpers.Constants;

public class DamageAngel extends Angel implements Visitor {
    public final void visit(Knight knight) {
        knight.increaseAll(Constants.DAMAGE_ANGEL_K);
    }

    public final void visit(Pyromancer pyromancer) {
        pyromancer.increaseAll(Constants.DAMAGE_ANGEL_P);
    }

    public final void visit(Rogue rogue) {
        rogue.increaseAll(Constants.DAMAGE_ANGEL_R);
    }

    public final void visit(Wizard wizard) {
        wizard.increaseAll(Constants.DAMAGE_ANGEL_W);
    }
}
