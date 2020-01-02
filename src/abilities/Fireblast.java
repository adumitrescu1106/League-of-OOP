package abilities;

import champions.Knight;
import champions.Pyromancer;
import champions.Rogue;
import champions.Wizard;
import helpers.Constants;

public class Fireblast extends Ability implements Visitor {
    private int fireblastDmg;

    public Fireblast() {
        this.fireblastDmg = Constants.FIREBLAST_DMG;
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
            knight.takeDmg(Math.round(fireblastDmg * Constants.VOLCANIC_LAND
                    * Constants.FIREBLAST_KNIGHT));
        } else {
            knight.takeDmg(Math.round(fireblastDmg * Constants.FIREBLAST_KNIGHT));
        }
    }

    @Override
    public final void visit(final Pyromancer pyromancer) {
        if (pyromancer.getPosition().equals('V')) {
            pyromancer.takeDmg(Math.round(fireblastDmg * Constants.VOLCANIC_LAND
                    * Constants.FIREBLAST_PYRO));
        } else {
            pyromancer.takeDmg(Math.round(fireblastDmg * Constants.FIREBLAST_PYRO));
        }
    }

    @Override
    public final void visit(final Rogue rogue) {
        if (rogue.getPosition().equals('V')) {
            rogue.takeDmg(Math.round(fireblastDmg * Constants.VOLCANIC_LAND
                    * Constants.FIREBLAST_ROGUE));
        } else {
            rogue.takeDmg(Math.round(fireblastDmg * Constants.FIREBLAST_ROGUE));
        }
    }

    @Override
    public final void visit(final Wizard wizard) {
        if (wizard.getPosition().equals('V')) {
            wizard.takeDmg(Math.round(fireblastDmg * Constants.VOLCANIC_LAND
                    * Constants.FIREBLAST_WIZARD));
            wizard.addDamageDeflect(Math.round(fireblastDmg * Constants.VOLCANIC_LAND));
        } else {
            wizard.takeDmg(Math.round(fireblastDmg * Constants.FIREBLAST_WIZARD));
            wizard.addDamageDeflect(Math.round(fireblastDmg));
        }
    }
    // se imbunatatesc abilitatile daca nivelul eroului creste
    public final void levelUP() {
        setFireblastDmg(getFireblastDmg() + Constants.FIREBLAST_UP);
    }
}
