package angels;

import abilities.Visitor;
import champions.Knight;
import champions.Pyromancer;
import champions.Rogue;
import champions.Wizard;

public class TheDoomer extends Angel implements Visitor {
    public TheDoomer(final int x, final int y) {
        super(x, y);
        this.setType("TheDoomer");
    }

    public final void visit(final Knight knight) {
        knight.setHp(0);
        knight.setState("dead");
    }

    public final void visit(final Pyromancer pyromancer) {
        pyromancer.setHp(0);
        pyromancer.setState("dead");
    }

    public final void visit(final Rogue rogue) {
        rogue.setHp(0);
        rogue.setState("dead");
    }

    public final void visit(final Wizard wizard) {
        wizard.setHp(0);
        wizard.setState("dead");
    }
}
