package angels;

import abilities.Visitor;
import champions.Knight;
import champions.Pyromancer;
import champions.Rogue;
import champions.Wizard;

public class LevelUpAngel extends Angel implements Visitor {
    public LevelUpAngel(int x, int y) {
        super(x, y);
        this.setType("LevelUpAngel");
    }

    public final void visit(Knight knight) {
        knight.levelUp();
        knight.setLevel(knight.getLevel() + 1);
    }

    public final void visit(Pyromancer pyromancer) {
        pyromancer.levelUp();
        pyromancer.setLevel(pyromancer.getLevel() + 1);
    }

    public final void visit(Rogue rogue) {
        rogue.levelUp();
        rogue.setLevel(rogue.getLevel() + 1);
    }

    public final void visit(Wizard wizard) {
        wizard.levelUp();
        wizard.setLevel(wizard.getLevel() + 1);
    }
}
