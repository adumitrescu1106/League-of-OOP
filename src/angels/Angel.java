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

    public Angel(int x, int y) {
        this.xPosition = x;
        this.yPosition = y;
        this.type = "angel";
    }

    public void visit(Knight knight) {

    }

    public void visit(Pyromancer pyromancer) {

    }

    public void visit(Rogue rogue) {

    }

    public void visit(Wizard wizard) {

    }

    public final int getxPosition() {
        return xPosition;
    }

    public final void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public final int getyPosition() {
        return yPosition;
    }

    public final void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public final String getType() {
        return type;
    }

    public final void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Angel{" +
                "xPosition=" + xPosition +
                ", yPosition=" + yPosition +
                ", type='" + type + '\'' +
                '}';
    }
}
