package angels;

import abilities.Visitor;
import champions.Knight;
import champions.Pyromancer;
import champions.Rogue;
import champions.Wizard;
import helpers.Constants;

public class Spawner extends Angel implements Visitor {
    public final void visit(Knight knight) {
        if (knight.getHp() <= 0) {
            knight.setHp(Constants.REVIVE_KNIGHT);
            knight.setState("alive");
        }
    }

    public final void visit(Pyromancer pyromancer) {
        if (pyromancer.getHp() <= 0) {
            pyromancer.setHp(Constants.REVIVE_PYRO);
            pyromancer.setState("alive");
        }
    }

    public final void visit(Rogue rogue) {
        if (rogue.getHp() <= 0) {
            rogue.setHp(Constants.REVIVE_ROGUE);
            rogue.setState("alive");
        }
    }

    public final void visit(Wizard wizard) {
        if (wizard.getHp() <= 0) {
            wizard.setHp(Constants.REVIVE_WIZARD);
            wizard.setState("alive");
        }
    }
}
