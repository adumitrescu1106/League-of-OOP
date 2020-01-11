package champions;

import abilities.Visitor;
import helpers.Constants;

import java.util.ArrayList;

public class Rogue extends Champion implements Visitable {
    private String type;
    private String longType;

    public Rogue() {
        super();
        this.setHp(Constants.ROGUE_HP);
        this.type = "R";
        this.longType = "Rogue";
    }

    public Rogue(final int x, final int y, final ArrayList<ArrayList<Character>> arena) {
        super(x, y, arena);
        this.setHp(Constants.ROGUE_HP);
        this.type = "R";
        this.longType = "Rogue";
        this.setkFirstModifier(Constants.BACKSTAB_KNIGHT);
        this.setkSecondModifier(Constants.PARALYSIS_KNIGHT);
        this.setpFirstModifier(Constants.BACKSTAB_PYRO);
        this.setpSecondModifier(Constants.PARALYSIS_PYRO);
        this.setrFirstModifier(Constants.BACKSTAB_ROGUE);
        this.setrSecondModifier(Constants.PARALYSIS_ROGUE);
        this.setwFirstModifier(Constants.BACKSTAB_WIZARD);
        this.setwSecondModifier(Constants.PARALYSIS_WIZARD);
    }

    public final String getType() {
        return type;
    }

    public final void setType(final String type) {
        this.type = type;
    }

    public final String getLongType() {
        return longType;
    }

    public final void setLongType(String longType) {
        this.longType = longType;
    }

    // se creste hp ul maxim si se face heal la 100% cand da level up
    public final void levelUp() {
        this.setHp(Constants.ROGUE_HP + this.getLevel() * Constants.ROGUE_HP_UP);
    }
    @Override
    public final void accept(final Visitor v) {
        v.visit(this);
    }

    public final void playStyle() {
        if (((Constants.ROGUE_HP + Constants.ROGUE_HP_UP * this.getLevel())
                / Constants.STRATEGY_R_1) < this.getHp() && this.getHp()
                < ((Constants.ROGUE_HP + Constants.ROGUE_HP_UP * this.getLevel())
                / Constants.STRATEGY_R_2)) {
            this.takeDmg(this.getHp() / Constants.LIFE_ROGUE_AGGR);
            this.increaseAll(Constants.AGGRESSIVE_R);
        } else if (this.getHp() < ((Constants.ROGUE_HP + Constants.ROGUE_HP_UP * this.getLevel())
                / Constants.STRATEGY_R_1)) {
            this.heal(this.getHp() / Constants.LIFE_ROGUE_DEF);
            this.decreaseAll(Constants.DEFENSIVE_R);
        }
    }
}
