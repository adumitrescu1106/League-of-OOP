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
        knight.setOvertimeDmg(Math.round(paralysisDmg * Constants.PARALYSIS_KNIGHT));
        // se seteaza tipul damage-ului overtime, durata si valoarea damage-ului
        if (knight.getPosition().equals('W')) {
            knight.takeDmg(Math.round(paralysisDmg * Constants.WOODS_LAND
                    * Constants.PARALYSIS_KNIGHT));
            knight.setOvertimeDmg(Math.round(paralysisDmg * Constants.PARALYSIS_KNIGHT
                    * Constants.WOODS_LAND));
            knight.setOvertimeType("paralysis_extra");
            knight.setParalysis(Constants.PARALYSIS_EXTRA);
            knight.setOvertimeDuration(Constants.PARALYSIS_EXTRA);
            // se seteaza tipul damage-ului overtime, durata si valoarea damage-ului
            // in cazul in care se primesc bonusurile
        } else {
            knight.takeDmg(Math.round(paralysisDmg * Constants.PARALYSIS_KNIGHT));
        }
    }

    @Override
    public final void visit(final Pyromancer pyromancer) {
        pyromancer.setOvertimeType("paralysis");
        pyromancer.setParalysis(Constants.PARALYSIS_ROUNDS);
        pyromancer.setOvertimeDuration(Constants.PARALYSIS_ROUNDS);
        pyromancer.setOvertimeDmg(Math.round(paralysisDmg * Constants.PARALYSIS_PYRO));
        if (pyromancer.getPosition().equals('W')) {
            pyromancer.takeDmg(Math.round(paralysisDmg * Constants.WOODS_LAND
                    * Constants.PARALYSIS_PYRO));
            pyromancer.setOvertimeDmg(Math.round(paralysisDmg * Constants.WOODS_LAND
                    * Constants.PARALYSIS_PYRO));
            pyromancer.setOvertimeType("paralysis_extra");
            pyromancer.setParalysis(Constants.PARALYSIS_EXTRA);
            pyromancer.setOvertimeDuration(Constants.PARALYSIS_EXTRA);
        } else {
            pyromancer.takeDmg(Math.round(paralysisDmg * Constants.PARALYSIS_PYRO));
        }
    }

    @Override
    public final void visit(final Rogue rogue) {
        rogue.setOvertimeType("paralysis");
        rogue.setParalysis(Constants.PARALYSIS_ROUNDS);
        rogue.setOvertimeDuration(Constants.PARALYSIS_ROUNDS);
        rogue.setOvertimeDmg(Math.round(paralysisDmg * Constants.PARALYSIS_ROGUE));
        if (rogue.getPosition().equals('W')) {
            rogue.takeDmg(Math.round(paralysisDmg * Constants.WOODS_LAND
                    * Constants.PARALYSIS_ROGUE));
            rogue.setOvertimeDmg(Math.round(paralysisDmg * Constants.WOODS_LAND
                    * Constants.PARALYSIS_ROGUE));
            rogue.setOvertimeType("paralysis_extra");
            rogue.setParalysis(Constants.PARALYSIS_EXTRA);
            rogue.setOvertimeDuration(Constants.PARALYSIS_EXTRA);
        } else {
            rogue.takeDmg(Math.round(paralysisDmg * Constants.PARALYSIS_ROGUE));
        }
    }

    @Override
    public final void visit(final Wizard wizard) {
        wizard.setOvertimeType("paralysis");
        wizard.setParalysis(Constants.PARALYSIS_ROUNDS);
        wizard.setOvertimeDuration(Constants.PARALYSIS_ROUNDS);
        wizard.setOvertimeDmg(Math.round(paralysisDmg * Constants.PARALYSIS_WIZARD));
        if (wizard.getPosition().equals('W')) {
            wizard.takeDmg(Math.round(paralysisDmg * Constants.WOODS_LAND
                    * Constants.PARALYSIS_WIZARD));
            wizard.setOvertimeDmg(Math.round(paralysisDmg * Constants.WOODS_LAND
                    * Constants.PARALYSIS_WIZARD));
            wizard.setParalysis(Constants.PARALYSIS_EXTRA);
            wizard.setOvertimeDuration(Constants.PARALYSIS_EXTRA);
            wizard.setOvertimeType("paralysis_extra");
            // deflect info
            wizard.addDamageDeflect(Math.round(paralysisDmg * Constants.WOODS_LAND));
        } else {
            wizard.takeDmg(Math.round(paralysisDmg * Constants.PARALYSIS_WIZARD));
            wizard.addDamageDeflect(Math.round(paralysisDmg));
        }
    }

    public final void levelUP() {
        setParalysisDmg(getParalysisDmg() + Constants.PARALYSIS_UP);
    }
}
