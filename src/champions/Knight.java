package champions;

import abilities.Visitor;
import helpers.Constants;

import java.util.ArrayList;

public class Knight extends Champion implements Visitable {
    private String type;

    public Knight() {
        super();
        this.setHp(Constants.KNIGHT_HP);
        this.type = "K";
    }

    public Knight(final int x, final int y, final ArrayList<ArrayList<Character>> arena) {
        super(x, y, arena);
        this.setHp(Constants.KNIGHT_HP);
        this.type = "K";
        this.setkFirstModifier(0);
        this.setkSecondModifier(Constants.SLAM_KNIGHT);
        this.setpFirstModifier(Constants.EXECUTE_PYRO);
        this.setpSecondModifier(Constants.SLAM_PYRO);
        this.setrFirstModifier(Constants.EXECUTE_ROGUE);
        this.setrSecondModifier(Constants.SLAM_ROGUE);
        this.setwFirstModifier(Constants.EXECUTE_WIZARD);
        this.setwSecondModifier(Constants.SLAM_WIZARD);
    }

    public final String getType() {
        return type;
    }

    public final void setType(final String type) {
        this.type = type;
    }

    public final void accept(final Visitor v) {
        v.visit(this);
    }

    // se creste hp ul maxim si se face heal la 100% cand da level up
    public final void levelUp() {
        this.setHp(Constants.KNIGHT_HP + this.getLevel() * Constants.KNIGHT_HP_UP);
    }
}
