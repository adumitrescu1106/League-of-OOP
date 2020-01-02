package champions;

import abilities.Visitor;
import helpers.Constants;

import java.util.ArrayList;

public class Pyromancer extends Champion implements Visitable {
    private String type;

    public Pyromancer() {
        super();
        this.setHp(Constants.PYROMANCER_HP);
        this.type = "P";
    }
    public Pyromancer(final int x, final int y, final ArrayList<ArrayList<Character>> arena) {
        super(x, y, arena);
        this.setHp(Constants.PYROMANCER_HP);
        this.type = "P";
    }

    public final String getType() {
        return type;
    }

    public final void setType(final String type) {
        this.type = type;
    }

    // se creste hp ul maxim si se face heal la 100% cand da level up
    public final void levelUp() {
        this.setHp(Constants.PYROMANCER_HP + this.getLevel() * Constants.PYROMANCER_HP_UP);
    }
    @Override
    public final void accept(final Visitor v) {
        v.visit(this);
    }
}
