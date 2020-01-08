package angels;

import abilities.Visitor;
import champions.Knight;
import champions.Pyromancer;
import champions.Rogue;
import champions.Wizard;
import helpers.Constants;

public class LevelUpAngel extends Angel implements Visitor {
    public LevelUpAngel(int x, int y) {
        super(x, y);
        this.setType("LevelUpAngel");
    }

    public final void visit(Knight knight) {
        knight.levelUp();
        knight.setXp(Constants.LEVEL_EXPERIENCE + Constants.FRACTION_EXP * knight.getLevel());
        knight.setLevel(knight.getLevel() + 1);
    }

    public final void visit(Pyromancer pyromancer) {
        pyromancer.levelUp();
        pyromancer.setXp(Constants.LEVEL_EXPERIENCE + Constants.FRACTION_EXP * pyromancer.getLevel());
        pyromancer.setLevel(pyromancer.getLevel() + 1);
    }

    public final void visit(Rogue rogue) {
        rogue.levelUp();
        rogue.setXp(Constants.LEVEL_EXPERIENCE + Constants.FRACTION_EXP * rogue.getLevel());
        rogue.setLevel(rogue.getLevel() + 1);
    }

    public final void visit(Wizard wizard) {
        wizard.levelUp();
        wizard.setXp(Constants.LEVEL_EXPERIENCE + Constants.FRACTION_EXP * wizard.getLevel());
        wizard.setLevel(wizard.getLevel() + 1);
    }
}
