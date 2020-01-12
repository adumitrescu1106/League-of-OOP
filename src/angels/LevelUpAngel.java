package angels;

import abilities.Visitor;
import champions.Knight;
import champions.Pyromancer;
import champions.Rogue;
import champions.Wizard;
import helpers.Constants;

public class LevelUpAngel extends Angel implements Visitor {
    public LevelUpAngel(final int x, final int y) {
        super(x, y);
        this.setType("LevelUpAngel");
    }

    public final void visit(final Knight knight) {
        knight.setXp(Constants.LEVEL_EXPERIENCE + Constants.FRACTION_EXP * knight.getLevel());
        knight.setLevel(knight.getLevel() + 1);
        knight.levelUp();
        knight.increaseAll(Constants.LEVEL_ANGEL_K);
    }

    public final void visit(final Pyromancer pyromancer) {
        pyromancer.setXp(Constants.LEVEL_EXPERIENCE + Constants.FRACTION_EXP
                * pyromancer.getLevel());
        pyromancer.setLevel(pyromancer.getLevel() + 1);
        pyromancer.levelUp();
        pyromancer.increaseAll(Constants.LEVEL_ANGEL_P);
    }

    public final void visit(final Rogue rogue) {
        rogue.setXp(Constants.LEVEL_EXPERIENCE + Constants.FRACTION_EXP * rogue.getLevel());
        rogue.setLevel(rogue.getLevel() + 1);
        rogue.levelUp();
        rogue.increaseAll(Constants.LEVEL_ANGEL_R);
    }

    public final void visit(final Wizard wizard) {
        wizard.setXp(Constants.LEVEL_EXPERIENCE + Constants.FRACTION_EXP * wizard.getLevel());
        wizard.setLevel(wizard.getLevel() + 1);
        wizard.levelUp();
        wizard.increaseAll(Constants.LEVEL_ANGEL_W);
    }
}
