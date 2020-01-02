package angels;

import abilities.Visitor;
import champions.Knight;
import champions.Pyromancer;
import champions.Rogue;
import champions.Wizard;
import helpers.Constants;

public class XPAngel extends Angel implements Visitor {
    public final void visit(Knight knight) {
        knight.addXp(Constants.XP_KNIGHT);
    }

    public final void visit(Pyromancer pyromancer) {
        pyromancer.addXp(Constants.XP_PYRO);
    }

    public final void visit(Rogue rogue) {
        rogue.addXp(Constants.XP_ROGUE);
    }

    public final void visit(Wizard wizard) {
        wizard.addXp(Constants.XP_WIZARD);
    }
}
