package angels;

import abilities.Visitor;
import champions.Knight;
import champions.Pyromancer;
import champions.Rogue;
import champions.Wizard;
import helpers.Constants;

public class LifeGiver extends Angel implements Visitor {
    public final void visit(Knight knight) {
        knight.heal(Constants.LIFE_KNIGHT_DMG);
    }

    public final void visit(Pyromancer pyromancer) {
        pyromancer.heal(Constants.LIFE_PYRO_DMG);
    }

    public final void visit(Rogue rogue) {
        rogue.heal(Constants.LIFE_ROGUE_DMG);
    }

    public final void visit(Wizard wizard) {
        wizard.heal(Constants.LIFE_WIZARD_DMG);
    }
}
