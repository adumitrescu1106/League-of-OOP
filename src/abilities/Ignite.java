package abilities;

import champions.Knight;
import champions.Pyromancer;
import champions.Rogue;
import champions.Wizard;
import helpers.Constants;

public class Ignite extends Ability implements Visitor {
    private int igniteDmg;
    private int igniteOvertime;

    public Ignite() {
        this.igniteDmg = Constants.IGNITE_BASE_DMG;
        this.igniteOvertime = Constants.IGNITE_OVERTIME;
    }

    public final int getIgniteDmg() {
        return igniteDmg;
    }

    public final void setIgniteDmg(final int igniteDmg) {
        this.igniteDmg = igniteDmg;
    }

    public final int getIgniteOvertime() {
        return igniteOvertime;
    }

    public final void setIgniteOvertime(final int igniteOvertime) {
        this.igniteOvertime = igniteOvertime;
    }

    // se calculeaza damage-ul pe care trebuie sa-l dea ignite-ul fiecarei
    // clase de campioni
    public final void visit(final Knight knight) {
        // se seteaza tipul damage-ului overtime, durata si damage-ul
        knight.setOvertimeType("ignite");
        knight.setOvertimeDuration(Constants.IGNITE_ROUNDS);
        knight.setOvertimeDmg(Math.round(igniteOvertime * Constants.IGNITE_KNIGHT));
        if (knight.getPosition().equals('V')) {
            // se aplica damage-ul din runda in care este castat ignite-ul
            knight.takeDmg(Math.round(igniteDmg * Constants.VOLCANIC_LAND
                    * Constants.IGNITE_KNIGHT));
            knight.setOvertimeDmg(Math.round(igniteOvertime * Constants.IGNITE_KNIGHT
                    * Constants.VOLCANIC_LAND));
        } else {
            knight.takeDmg(Math.round(igniteDmg * Constants.IGNITE_KNIGHT));
        }
    }

    @Override
    public final void visit(final Pyromancer pyromancer) {
        pyromancer.setOvertimeType("ignite");
        pyromancer.setOvertimeDuration(Constants.IGNITE_ROUNDS);
        pyromancer.setOvertimeDmg(Math.round(igniteOvertime * Constants.IGNITE_PYRO));
        if (pyromancer.getPosition().equals('V')) {
            pyromancer.takeDmg(Math.round(igniteDmg * Constants.VOLCANIC_LAND
                    * Constants.IGNITE_PYRO));
            pyromancer.setOvertimeDmg(Math.round(igniteOvertime * Constants.IGNITE_PYRO
                    * Constants.VOLCANIC_LAND));
        } else {
            pyromancer.takeDmg(Math.round(igniteDmg * Constants.IGNITE_PYRO));
        }
    }

    @Override
    public final void visit(final Rogue rogue) {
        rogue.setOvertimeType("ignite");
        rogue.setOvertimeDuration(Constants.IGNITE_ROUNDS);
        rogue.setOvertimeDmg(Math.round(igniteOvertime * Constants.IGNITE_ROGUE));
        if (rogue.getPosition().equals('V')) {
            rogue.takeDmg(Math.round(igniteDmg * Constants.VOLCANIC_LAND * Constants.IGNITE_ROGUE));
            rogue.setOvertimeDmg(Math.round(igniteOvertime * Constants.IGNITE_ROGUE
                    * Constants.VOLCANIC_LAND));
        } else {
            rogue.takeDmg(Math.round(igniteDmg * Constants.IGNITE_ROGUE));
        }
    }

    @Override
    public final void visit(final Wizard wizard) {
        wizard.setOvertimeType("ignite");
        wizard.setOvertimeDuration(Constants.IGNITE_ROUNDS);
        wizard.setOvertimeDmg(Math.round(igniteOvertime * Constants.IGNITE_WIZARD));
        if (wizard.getPosition().equals('V')) {
            wizard.takeDmg(Math.round(igniteDmg * Constants.VOLCANIC_LAND
                    * Constants.IGNITE_WIZARD));
            wizard.setOvertimeDmg(Math.round(igniteOvertime * Constants.IGNITE_WIZARD
                    * Constants.VOLCANIC_LAND));
            wizard.addDamageDeflect(Math.round(igniteDmg * Constants.VOLCANIC_LAND));
        } else {
            wizard.takeDmg(Math.round(igniteDmg * Constants.IGNITE_WIZARD));
            wizard.addDamageDeflect(Math.round(igniteDmg));
        }
    }

    // se imbunatatesc abilitatile daca nivelul eroului creste
    public final void levelUP() {
        setIgniteDmg(getIgniteDmg() + Constants.IGNITE_BASE_UP);
        setIgniteOvertime(getIgniteOvertime() + Constants.IGNITE_OVER_UP);
    }
}
