package abilities;

import champions.Knight;
import champions.Pyromancer;
import champions.Rogue;
import champions.Wizard;
import helpers.Constants;

public class Slam extends Ability implements Visitor {
    private int slamDmg;

    public Slam() {
        this.slamDmg = Constants.SLAM_DMG;
        this.setKnightModifier(Constants.SLAM_KNIGHT);
        this.setPyroModifier(Constants.SLAM_PYRO);
        this.setRogueModifier(Constants.SLAM_ROGUE);
        this.setWizardModifier(Constants.SLAM_WIZARD);
    }
    @Override
    public final void visit(final Knight knight) {
        if (knight.getPosition().equals('L')) {
            knight.takeDmg(Math.round(slamDmg * this.getKnightModifier() * Constants.KNIGHT_LAND));
        } else {
            knight.takeDmg(Math.round(slamDmg * this.getKnightModifier()));
        }
        // se seteaza starea de paralizie pentru 1 runda
        knight.setParalysis(1);
    }

    @Override
    public final void visit(final Pyromancer pyromancer) {
       if (pyromancer.getPosition().equals('L')) {
           pyromancer.takeDmg(Math.round(slamDmg * this.getPyroModifier() * Constants.KNIGHT_LAND));
       } else {
           pyromancer.takeDmg(Math.round(slamDmg * this.getPyroModifier()));
       }
       pyromancer.setParalysis(1);
    }

    @Override
    public final void visit(final Rogue rogue) {
        if (rogue.getPosition().equals('L')) {
            rogue.takeDmg(Math.round(slamDmg * this.getRogueModifier() * Constants.KNIGHT_LAND));

//            System.out.println("slam " + Math.round(slamDmg * this.getRogueModifier() * Constants.KNIGHT_LAND));
//            System.out.println("slam coef " + this.getRogueModifier());
        } else {
            rogue.takeDmg(Math.round(slamDmg * this.getRogueModifier()));
//            System.out.println("slam " + Math.round(slamDmg * this.getRogueModifier()));
//            System.out.println("slam coef " + this.getRogueModifier());
        }
        rogue.setParalysis(1);
    }

    @Override
    public final void visit(final Wizard wizard) {
        if (wizard.getPosition().equals('L')) {
            wizard.takeDmg(Math.round(slamDmg * this.getWizardModifier() * Constants.KNIGHT_LAND));
            wizard.addDamageDeflect(Math.round(slamDmg * Constants.KNIGHT_LAND));
        } else {
            wizard.takeDmg(Math.round(slamDmg * this.getWizardModifier()));
            wizard.addDamageDeflect(Math.round(slamDmg));
        }
        // se seteaza starea de paralizie pentru 1 runda
        wizard.setParalysis(1);
    }
    // se imbunatatesc abilitatile daca nivelul eroului creste
    public final void levelUP() {
        setSlamDmg(getSlamDmg() + Constants.SLAM_UP);
    }

    public final int getSlamDmg() {
        return slamDmg;
    }

    public final void setSlamDmg(final int slamDmg) {
        this.slamDmg = slamDmg;
    }
}
