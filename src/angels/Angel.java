package angels;

import abilities.Visitor;
import champions.Knight;
import champions.Pyromancer;
import champions.Rogue;
import champions.Wizard;

public class Angel implements Visitor {
    private int xPosition;
    private int yPosition;
    private String type;

    public Angel(final int x, final int y) {
        this.xPosition = x;
        this.yPosition = y;
        this.type = "angel";
    }

    public void visit(final Knight knight) {

    }

    public void visit(final Pyromancer pyromancer) {

    }

    public void visit(final Rogue rogue) {

    }

    public void visit(final Wizard wizard) {

    }

    public final int getxPosition() {
        return xPosition;
    }

    public final void setxPosition(final int xPosition) {
        this.xPosition = xPosition;
    }

    public final int getyPosition() {
        return yPosition;
    }

    public final void setyPosition(final int yPosition) {
        this.yPosition = yPosition;
    }

    public final String getType() {
        return type;
    }

    public final void setType(final String type) {
        this.type = type;
    }

}
