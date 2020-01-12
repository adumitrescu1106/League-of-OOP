package champions;

import abilities.Visitor;
import helpers.Constants;

import java.util.ArrayList;

public class Pyromancer extends Champion implements Visitable {
    private String type;
    private String longType;

    public Pyromancer() {
        super();
        this.setHp(Constants.PYROMANCER_HP);
        this.type = "P";
        this.longType = "Pyromancer";
    }
    public Pyromancer(final int x, final int y, final ArrayList<ArrayList<Character>> arena) {
        super(x, y, arena);
        this.setHp(Constants.PYROMANCER_HP);
        this.type = "P";
        this.longType = "Pyromancer";
        this.setkFirstModifier(Constants.FIREBLAST_KNIGHT);
        this.setkSecondModifier(Constants.IGNITE_KNIGHT);
        this.setpFirstModifier(Constants.FIREBLAST_PYRO);
        this.setpSecondModifier(Constants.IGNITE_PYRO);
        this.setrFirstModifier(Constants.FIREBLAST_ROGUE);
        this.setrSecondModifier(Constants.IGNITE_ROGUE);
        this.setwFirstModifier(Constants.FIREBLAST_WIZARD);
        this.setwSecondModifier(Constants.IGNITE_WIZARD);
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

    public final void setLongType(final String longType) {
        this.longType = longType;
    }

    // se creste hp ul maxim si se face heal la 100% cand da level up
    public final void levelUp() {
        this.setHp(Constants.PYROMANCER_HP + this.getLevel() * Constants.PYROMANCER_HP_UP);
    }
    @Override
    public final void accept(final Visitor v) {
        v.visit(this);
    }
    // strategy
    public final void playStyle() {
        if (((Constants.PYROMANCER_HP + Constants.PYROMANCER_HP_UP * this.getLevel())
                / Constants.STRATEGY_P_1) < this.getHp() && this.getHp()
                < ((Constants.PYROMANCER_HP + Constants.PYROMANCER_HP_UP * this.getLevel())
                / Constants.STRATEGY_P_2)) {
            this.takeDmg(this.getHp() / Constants.LIFE_PYRO_AGGR);
            this.increaseAll(Constants.AGGRESSIVE_P);
        } else if (this.getHp() < ((Constants.PYROMANCER_HP + Constants.PYROMANCER_HP_UP
                * this.getLevel())
                / Constants.STRATEGY_P_1)) {
            this.heal(this.getHp() / Constants.LIFE_PYRO_DEF);
            this.decreaseAll(Constants.DEFENSIVE_P);
        }
    }
}
