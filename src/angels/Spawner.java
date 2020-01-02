package angels;

import abilities.Visitor;
import champions.Knight;
import champions.Pyromancer;
import champions.Rogue;
import champions.Wizard;
import helpers.Constants;

public class Spawner extends Angel implements Visitor {
    public final void visit(Knight knight) {
        knight.setHp(Constants.REVIVE_KNIGHT);
        knight.setState("alive");
    }

    public final void visit(Pyromancer pyromancer) {
        pyromancer.setHp(Constants.REVIVE_PYRO);
        pyromancer.setState("alive");
    }

    public final void visit(Rogue rogue) {
        rogue.setHp(Constants.REVIVE_ROGUE);
        rogue.setState("alive");
    }

    public final void visit(Wizard wizard) {
        wizard.setHp(Constants.REVIVE_WIZARD);
        wizard.setState("alive");
    }
}
