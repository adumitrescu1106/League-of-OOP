package angels;

import abilities.Visitor;
import champions.Knight;
import champions.Pyromancer;
import champions.Rogue;
import champions.Wizard;
import helpers.Constants;

public class Spawner extends Angel implements Visitor {
    public Spawner(final int x, final int y) {
        super(x, y);
        this.setType("Spawner");
    }

    public final void visit(final Knight knight) {
        if (knight.getHp() <= 0) {
            knight.setHp(Constants.REVIVE_KNIGHT);
            knight.setState("alive");
        }
    }

    public final void visit(final Pyromancer pyromancer) {
        if (pyromancer.getHp() <= 0) {
            pyromancer.setHp(Constants.REVIVE_PYRO);
            pyromancer.setState("alive");
        }
    }

    public final void visit(final Rogue rogue) {
        if (rogue.getHp() <= 0) {
            rogue.setHp(Constants.REVIVE_ROGUE);
            rogue.setState("alive");
        }
    }

    public final void visit(final Wizard wizard) {
        if (wizard.getHp() <= 0) {
            wizard.setHp(Constants.REVIVE_WIZARD);
            wizard.setState("alive");
        }
    }
}
