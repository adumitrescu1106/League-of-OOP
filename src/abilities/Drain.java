package abilities;

import champions.Knight;
import champions.Pyromancer;
import champions.Rogue;
import champions.Wizard;
import helpers.Constants;

public class Drain extends Ability implements Visitor {
    private float hpPercent;

    public Drain() {
        this.hpPercent = Constants.DRAIN_PERCENT;
        this.setKnightModifier(Constants.DRAIN_KNIGHT);
        this.setPyroModifier(Constants.DRAIN_PYRO);
        this.setRogueModifier(Constants.DRAIN_ROGUE);
        this.setWizardModifier(Constants.DRAIN_WIZARD);
    }

    public final float getHpPercent() {
        return hpPercent;
    }

    public final void setHpPercent(final float hpPercent) {
        this.hpPercent = hpPercent;
    }
    // se imbunatatesc abilitatile daca nivelul eroului creste
    public final void levelUP() {
        setHpPercent(getHpPercent() + Constants.DRAIN_UP);
    }

    // se calculeaza drain-ul pentru fiecare tip de inamic posibil
    public final void visit(final Knight knight) {
        if (knight.getPosition().equals('D')) {
            knight.takeDmg(Math.round(hpPercent * this.getKnightModifier()
                    * Math.min(Constants.HP_PERCENT * (Constants.KNIGHT_HP
                    + Constants.KNIGHT_HP_UP * knight.getLevel()), knight.getHp())
                    * Constants.DESERT_LAND));
        } else {
            knight.takeDmg(Math.round(hpPercent * this.getKnightModifier()
                    * Math.min(Constants.HP_PERCENT * (Constants.KNIGHT_HP
                    + Constants.KNIGHT_HP_UP * knight.getLevel()), knight.getHp())));
        }
    }

    public final void visit(final Pyromancer pyromancer) {
        if (pyromancer.getPosition().equals('D')) {
            pyromancer.takeDmg(Math.round(hpPercent * this.getPyroModifier()
                    * Math.min(Constants.HP_PERCENT * (Constants.PYROMANCER_HP
                    + Constants.PYROMANCER_HP_UP * pyromancer.getLevel()), pyromancer.getHp())
                    * Constants.DESERT_LAND));
        } else {
            pyromancer.takeDmg(Math.round(hpPercent * this.getPyroModifier()
                    * Math.min(Constants.HP_PERCENT * (Constants.PYROMANCER_HP
                    + Constants.PYROMANCER_HP_UP * pyromancer.getLevel()), pyromancer.getHp())));
        }
    }

    public final void visit(final Rogue rogue) {
        if (rogue.getPosition().equals('D')) {
            rogue.takeDmg(Math.round(hpPercent * this.getRogueModifier()
                    * Math.min(Constants.HP_PERCENT * (Constants.ROGUE_HP
                    + Constants.ROGUE_HP_UP * rogue.getLevel()), rogue.getHp())
                    * Constants.DESERT_LAND));
        } else {
            rogue.takeDmg(Math.round(hpPercent * this.getRogueModifier()
                    * Math.min(Constants.HP_PERCENT * (Constants.ROGUE_HP
                    + Constants.ROGUE_HP_UP * rogue.getLevel()), rogue.getHp())));
        }
    }

    public final void visit(final Wizard wizard) {
        if (wizard.getPosition().equals('D')) {
            wizard.takeDmg(Math.round(hpPercent * this.getWizardModifier()
                    * Math.min(Constants.HP_PERCENT * (Constants.WIZARD_HP
                    + Constants.WIZARD_HP_UP * wizard.getLevel()), wizard.getHp())
                    * Constants.DESERT_LAND));
        } else {
            wizard.takeDmg(Math.round(hpPercent * this.getWizardModifier()
                    * Math.min(Constants.HP_PERCENT * (Constants.WIZARD_HP
                    + Constants.WIZARD_HP_UP * wizard.getLevel()), wizard.getHp())));
        }
    }
}
