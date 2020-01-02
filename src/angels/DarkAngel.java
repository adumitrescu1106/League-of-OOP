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
    }

    public final void visit(Pyromancer pyromancer) {
        pyromancer.takeDmg(Constants.DARK_PYRO_DMG);
    }

    public final void visit(Rogue rogue) {
        rogue.takeDmg(Constants.DARK_ROGUE_DMG);
    }

    public final void visit(Wizard wizard) {
        wizard.takeDmg(Constants.DARK_WIZARD_DMG);
    }
}
