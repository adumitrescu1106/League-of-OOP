package abilities;

import champions.Knight;
import champions.Pyromancer;
import champions.Rogue;
import champions.Wizard;
import helpers.Constants;
import jdk.swing.interop.SwingInterOpUtils;

public class Fireblast extends Ability implements Visitor {
    private int fireblastDmg;

    public Fireblast() {
        this.fireblastDmg = Constants.FIREBLAST_DMG;
        this.setKnightModifier(Constants.FIREBLAST_KNIGHT);
        this.setPyroModifier(Constants.FIREBLAST_PYRO);
        this.setRogueModifier(Constants.FIREBLAST_ROGUE);
        this.setWizardModifier(Constants.FIREBLAST_WIZARD);
    }

    public final int getFireblastDmg() {
        return fireblastDmg;
    }

    public final void setFireblastDmg(final int fireblastDmg) {
        this.fireblastDmg = fireblastDmg;
    }

    public final void visit(final Knight knight) {
        // se verifica daca fireblast-ul este imbunatatit de tipul terenului
        // pe care se desfasoara lupta
        if (knight.getPosition().equals('V')) {
            knight.takeDmg(Math.round(Math.round(fireblastDmg * Constants.VOLCANIC_LAND)
                    * this.getKnightModifier()));
        } else {
            knight.takeDmg(Math.round(fireblastDmg * this.getKnightModifier()));
        }
    }

    @Override
    public final void visit(final Pyromancer pyromancer) {
        if (pyromancer.getPosition().equals('V')) {
            pyromancer.takeDmg(Math.round(fireblastDmg * Constants.VOLCANIC_LAND
                    * this.getPyroModifier()));
//            System.out.println("fireblast" + Math.round(fireblastDmg * Constants.VOLCANIC_LAND
//                    * this.getPyroModifier()));
//            System.out.println("modifier " + this.getPyroModifier());
        } else {
            pyromancer.takeDmg(Math.round(fireblastDmg * this.getPyroModifier()));
//            System.out.println("fireblast" + Math.round(fireblastDmg
//                    * this.getPyroModifier()));
//            System.out.println("modifier " + this.getPyroModifier());
        }
    }

    @Override
    public final void visit(final Rogue rogue) {
        if (rogue.getPosition().equals('V')) {
            rogue.takeDmg(Math.round(fireblastDmg * Constants.VOLCANIC_LAND
                    * this.getRogueModifier()));
        } else {
            rogue.takeDmg(Math.round(fireblastDmg * this.getRogueModifier()));
        }
    }

    @Override
    public final void visit(final Wizard wizard) {
        if (wizard.getPosition().equals('V')) {
            wizard.takeDmg(Math.round(fireblastDmg * Constants.VOLCANIC_LAND
                    * this.getWizardModifier()));
            wizard.addDamageDeflect(Math.round(fireblastDmg * Constants.VOLCANIC_LAND));
        } else {
            wizard.takeDmg(Math.round(fireblastDmg * this.getWizardModifier()));
            wizard.addDamageDeflect(Math.round(fireblastDmg));
        }
    }
    // se imbunatatesc abilitatile daca nivelul eroului creste
    public final void levelUP() {
        setFireblastDmg(getFireblastDmg() + Constants.FIREBLAST_UP);
    }
}
