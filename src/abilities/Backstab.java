package abilities;

import champions.Knight;
import champions.Pyromancer;
import champions.Rogue;
import champions.Wizard;
import helpers.Constants;

public class Backstab extends Ability implements Visitor {
    private int backstabDmg;

    public Backstab() {
        this.backstabDmg = Constants.BACKSTAB_DMG;
        this.setKnightModifier(Constants.BACKSTAB_KNIGHT);
        this.setPyroModifier(Constants.BACKSTAB_PYRO);
        this.setRogueModifier(Constants.BACKSTAB_ROGUE);
        this.setWizardModifier(Constants.BACKSTAB_WIZARD);
    }

    public final int getBackstabDmg() {
        return backstabDmg;
    }

    public final void setBackstabDmg(final int backstabDmg) {
        this.backstabDmg = backstabDmg;
    }
    // se imbunatatesc abilitatile daca nivelul eroului creste
    public final void levelUP() {
        setBackstabDmg(getBackstabDmg() + Constants.BACKSTAB_UP);
    }

    public final void visit(final Knight knight) {
        // se verifica daca se poate aplica lovitura critica
        if (knight.getBackstabIndex() == 0) {
            if (knight.getPosition().equals('W')) {
                knight.takeDmg(Math.round(backstabDmg * Constants.WOODS_LAND
                        * this.getKnightModifier() * Constants.BACKSTAB_CRIT));
                knight.setBackstabIndex(Constants.BACKSTAB_INDEX);
                return;
            } else {
                knight.setBackstabIndex(Constants.BACKSTAB_INDEX);
            }
        }
        if (knight.getPosition().equals('W')) {
            knight.takeDmg(Math.round(backstabDmg * Constants.WOODS_LAND
                    * this.getKnightModifier()));
            knight.setBackstabIndex(knight.getBackstabIndex() - 1);
        } else {
            knight.takeDmg(Math.round(backstabDmg * this.getKnightModifier()));
            knight.setBackstabIndex(knight.getBackstabIndex() - 1);
        }
    }


    public final void visit(final Pyromancer pyromancer) {
        if (pyromancer.getBackstabIndex() == 0) {
            if (pyromancer.getPosition().equals('W')) {
                pyromancer.takeDmg(Math.round(backstabDmg * Constants.WOODS_LAND
                        * this.getPyroModifier() * Constants.BACKSTAB_CRIT));
                pyromancer.setBackstabIndex(Constants.BACKSTAB_INDEX);
                return;
            } else {
                pyromancer.setBackstabIndex(Constants.BACKSTAB_INDEX);
            }
        }
        if (pyromancer.getPosition().equals('W')) {
            pyromancer.takeDmg(Math.round(backstabDmg * Constants.WOODS_LAND
                    * this.getPyroModifier()));
            pyromancer.setBackstabIndex(pyromancer.getBackstabIndex() - 1);
        } else {
            pyromancer.takeDmg(Math.round(backstabDmg * this.getPyroModifier()));
            pyromancer.setBackstabIndex(pyromancer.getBackstabIndex() - 1);
        }
    }

    public final void visit(final Rogue rogue) {
        if (rogue.getBackstabIndex() == 0) {
            if (rogue.getPosition().equals('W')) {
                rogue.takeDmg(Math.round(backstabDmg * Constants.WOODS_LAND
                        * this.getRogueModifier() * Constants.BACKSTAB_CRIT));
                rogue.setBackstabIndex(Constants.BACKSTAB_INDEX);
                return;
            } else {
                rogue.setBackstabIndex(Constants.BACKSTAB_INDEX);
            }
        }
        if (rogue.getPosition().equals('W')) {
            rogue.takeDmg(Math.round(backstabDmg * Constants.WOODS_LAND
                    * this.getRogueModifier()));
            rogue.setBackstabIndex(rogue.getOvertimeDuration() - 1);
        } else {
            rogue.takeDmg(Math.round(backstabDmg * this.getRogueModifier()));
            rogue.setBackstabIndex(rogue.getOvertimeDuration() - 1);
        }
    }

    public final void visit(final Wizard wizard) {
        if (wizard.getBackstabIndex() == 0) {
            if (wizard.getPosition().equals('W')) {
                wizard.takeDmg(Math.round(backstabDmg * Constants.WOODS_LAND
                        * this.getWizardModifier() * Constants.BACKSTAB_CRIT));
                wizard.addDamageDeflect(Math.round(backstabDmg * Constants.WOODS_LAND
                        * Constants.BACKSTAB_CRIT));
                        wizard.setBackstabIndex(Constants.BACKSTAB_INDEX);
                return;
            } else {
                wizard.setBackstabIndex(Constants.BACKSTAB_INDEX);
            }
        }
        if (wizard.getPosition().equals('W')) {
            wizard.takeDmg(Math.round(backstabDmg * Constants.WOODS_LAND
                    *  this.getWizardModifier()));
            wizard.setBackstabIndex(wizard.getOvertimeDuration() - 1);
            wizard.addDamageDeflect(Math.round(backstabDmg * Constants.WOODS_LAND));
            // tot damageul primit de wizard se tine minte de-a lungul rundei
            // pentru aplicarea deflectului
        } else {
            wizard.takeDmg(Math.round(backstabDmg *  this.getWizardModifier()));
            wizard.setBackstabIndex(wizard.getOvertimeDuration() - 1);
            wizard.addDamageDeflect(Math.round(backstabDmg));
        }
    }
}
