package abilities;

import champions.Knight;
import champions.Pyromancer;
import champions.Rogue;
import champions.Wizard;

public class Ability implements Visitor {
    private float knightModifier;
    private float pyroModifier;
    private float rogueModifier;
    private float wizardModifier;

    public final float getKnightModifier() {
        return knightModifier;
    }

    public final void setKnightModifier(final float knightModifier) {
        this.knightModifier = knightModifier;
    }

    public final float getPyroModifier() {
        return pyroModifier;
    }

    public final void setPyroModifier(final float pyroModifier) {
        this.pyroModifier = pyroModifier;
    }

    public final float getRogueModifier() {
        return rogueModifier;
    }

    public final void setRogueModifier(final float rogueModifier) {
        this.rogueModifier = rogueModifier;
    }

    public final float getWizardModifier() {
        return wizardModifier;
    }

    public final void setWizardModifier(final float wizardModifier) {
        this.wizardModifier = wizardModifier;
    }

    public void levelUP() {
    }

    @Override
    public void visit(final Knight knight) {

    }

    @Override
    public void visit(final Pyromancer pyromancer) {

    }

    @Override
    public void visit(final Rogue rogue) {

    }

    @Override
    public void visit(final Wizard wizard) {

    }
}
