package abilities;

import champions.Knight;
import champions.Pyromancer;
import champions.Rogue;
import champions.Wizard;
import helpers.Constants;

public class Paralysis extends Ability implements Visitor {
    private int paralysisDmg;

    public Paralysis() {
        this.paralysisDmg = Constants.PARALYSIS_DMG;
        this.setKnightModifier(Constants.PARALYSIS_KNIGHT);
        this.setPyroModifier(Constants.PARALYSIS_PYRO);
        this.setRogueModifier(Constants.PARALYSIS_ROGUE);
        this.setWizardModifier(Constants.PARALYSIS_WIZARD);
    }

    public final int getParalysisDmg() {
        return paralysisDmg;
    }

    public final void setParalysisDmg(final int paralysisDmg) {
        this.paralysisDmg = paralysisDmg;
    }

    public final void visit(final Knight knight) {
        knight.setOvertimeType("paralysis");
        knight.setParalysis(Constants.PARALYSIS_ROUNDS);
        knight.setOvertimeDuration(Constants.PARALYSIS_ROUNDS);
        knight.setOvertimeDmg(Math.round(paralysisDmg * this.getKnightModifier()));
        // se seteaza tipul damage-ului overtime, durata si valoarea damage-ului
        if (knight.getPosition().equals('W')) {
            knight.takeDmg(Math.round(paralysisDmg * Constants.WOODS_LAND
                    * this.getKnightModifier()));
            knight.setOvertimeDmg(Math.round(paralysisDmg * this.getKnightModifier()
                    * Constants.WOODS_LAND));
            knight.setOvertimeType("paralysis_extra");
            knight.setParalysis(Constants.PARALYSIS_EXTRA);
            knight.setOvertimeDuration(Constants.PARALYSIS_EXTRA);
            // se seteaza tipul damage-ului overtime, durata si valoarea damage-ului
            // in cazul in care se primesc bonusurile
        } else {
            knight.takeDmg(Math.round(paralysisDmg * this.getKnightModifier()));
        }
    }

    @Override
    public final void visit(final Pyromancer pyromancer) {
        pyromancer.setOvertimeType("paralysis");
        pyromancer.setParalysis(Constants.PARALYSIS_ROUNDS);
        pyromancer.setOvertimeDuration(Constants.PARALYSIS_ROUNDS);
        pyromancer.setOvertimeDmg(Math.round(paralysisDmg * this.getPyroModifier()));
        if (pyromancer.getPosition().equals('W')) {
            pyromancer.takeDmg(Math.round(paralysisDmg * Constants.WOODS_LAND
                    * this.getPyroModifier()));
            pyromancer.setOvertimeDmg(Math.round(paralysisDmg * Constants.WOODS_LAND
                    * this.getPyroModifier()));
            pyromancer.setOvertimeType("paralysis_extra");
            pyromancer.setParalysis(Constants.PARALYSIS_EXTRA);
            pyromancer.setOvertimeDuration(Constants.PARALYSIS_EXTRA);
        } else {
            pyromancer.takeDmg(Math.round(paralysisDmg * this.getPyroModifier()));
        }
    }

    @Override
    public final void visit(final Rogue rogue) {
        rogue.setOvertimeType("paralysis");
        rogue.setParalysis(Constants.PARALYSIS_ROUNDS);
        rogue.setOvertimeDuration(Constants.PARALYSIS_ROUNDS);
        rogue.setOvertimeDmg(Math.round(paralysisDmg * this.getRogueModifier()));
        if (rogue.getPosition().equals('W')) {
            rogue.takeDmg(Math.round(paralysisDmg * Constants.WOODS_LAND
                    * this.getRogueModifier()));
            rogue.setOvertimeDmg(Math.round(paralysisDmg * Constants.WOODS_LAND
                    * this.getRogueModifier()));
            rogue.setOvertimeType("paralysis_extra");
            rogue.setParalysis(Constants.PARALYSIS_EXTRA);
            rogue.setOvertimeDuration(Constants.PARALYSIS_EXTRA);
        } else {
            rogue.takeDmg(Math.round(paralysisDmg * this.getRogueModifier()));
        }
    }

    @Override
    public final void visit(final Wizard wizard) {
        wizard.setOvertimeType("paralysis");
        wizard.setParalysis(Constants.PARALYSIS_ROUNDS);
        wizard.setOvertimeDuration(Constants.PARALYSIS_ROUNDS);
        wizard.setOvertimeDmg(Math.round(paralysisDmg * this.getWizardModifier()));
        if (wizard.getPosition().equals('W')) {
            wizard.takeDmg(Math.round(paralysisDmg * Constants.WOODS_LAND
                    * this.getWizardModifier()));
            wizard.setOvertimeDmg(Math.round(paralysisDmg * Constants.WOODS_LAND
                    * this.getWizardModifier()));
            wizard.setParalysis(Constants.PARALYSIS_EXTRA);
            wizard.setOvertimeDuration(Constants.PARALYSIS_EXTRA);
            wizard.setOvertimeType("paralysis_extra");
            // deflect info
            wizard.addDamageDeflect(Math.round(paralysisDmg * Constants.WOODS_LAND));
        } else {
            wizard.takeDmg(Math.round(paralysisDmg * this.getWizardModifier()));
            wizard.addDamageDeflect(Math.round(paralysisDmg));
        }
    }

    public final void levelUP() {
        setParalysisDmg(getParalysisDmg() + Constants.PARALYSIS_UP);
    }
}
