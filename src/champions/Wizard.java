package champions;

import abilities.Visitor;
import helpers.Constants;

import java.util.ArrayList;

public class Wizard extends Champion implements Visitable {
    private String type;
    private String longType;

    public Wizard() {
        super();
        this.setHp(Constants.WIZARD_HP);
        this.type = "W";
        this.longType = "Wizard";
    }
    public Wizard(final int x, final int y, final ArrayList<ArrayList<Character>> arena) {
        super(x, y, arena);
        this.setHp(Constants.WIZARD_HP);
        this.type = "W";
        this.longType = "Wizard";
        this.setkFirstModifier(Constants.DRAIN_KNIGHT);
        this.setkSecondModifier(Constants.DEFLECT_KNIGHT);
        this.setpFirstModifier(Constants.DRAIN_PYRO);
        this.setpSecondModifier(Constants.DEFLECT_PYRO);
        this.setrFirstModifier(Constants.DRAIN_ROGUE);
        this.setrSecondModifier(Constants.DEFLECT_ROGUE);
        this.setwFirstModifier(Constants.DRAIN_WIZARD);
        this.setwSecondModifier(0);
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
        this.setHp(Constants.WIZARD_HP + this.getLevel() * Constants.WIZARD_HP_UP);
    }
    @Override
    public final void accept(final Visitor v) {
        v.visit(this);
    }

    public final void playStyle() {
        if (((Constants.WIZARD_HP + Constants.WIZARD_HP_UP * this.getLevel())
                / Constants.STRATEGY_W_1) < this.getHp() && this.getHp()
                < ((Constants.WIZARD_HP + Constants.WIZARD_HP_UP * this.getLevel())
                / Constants.STRATEGY_W_2)) {
            this.takeDmg(this.getHp() / Constants.LIFE_WIZARD_AGGR);
            this.increaseAll(Constants.AGGRESSIVE_W);
        } else if (this.getHp() < ((Constants.WIZARD_HP + Constants.WIZARD_HP_UP * this.getLevel())
                / Constants.STRATEGY_W_1)) {
        this.heal(this.getHp() / Constants.LIFE_WIZARD_DEF);
        this.decreaseAll(Constants.DEFENSIVE_W);
        }
    }
}
