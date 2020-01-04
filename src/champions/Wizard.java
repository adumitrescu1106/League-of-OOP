package champions;

import abilities.Visitor;
import helpers.Constants;

import java.util.ArrayList;

public class Wizard extends Champion implements Visitable {
    private String type;

    public Wizard() {
        super();
        this.setHp(Constants.WIZARD_HP);
        this.type = "W";
    }
    public Wizard(final int x, final int y, final ArrayList<ArrayList<Character>> arena) {
        super(x, y, arena);
        this.setHp(Constants.WIZARD_HP);
        this.type = "W";
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

    // se creste hp ul maxim si se face heal la 100% cand da level up
    public final void levelUp() {
        this.setHp(Constants.WIZARD_HP + this.getLevel() * Constants.WIZARD_HP_UP);
    }
    @Override
    public final void accept(final Visitor v) {
        v.visit(this);
    }
}
