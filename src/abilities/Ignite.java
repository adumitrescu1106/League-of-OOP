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
        this.setKnightModifier(Constants.IGNITE_KNIGHT);
        this.setPyroModifier(Constants.IGNITE_PYRO);
        this.setRogueModifier(Constants.IGNITE_ROGUE);
        this.setWizardModifier(Constants.IGNITE_WIZARD);
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
        knight.setOvertimeDmg(Math.round(igniteOvertime * this.getKnightModifier()));
        if (knight.getPosition().equals('V')) {
            // se aplica damage-ul din runda in care este castat ignite-ul
            knight.takeDmg(Math.round(Math.round(igniteDmg * Constants.VOLCANIC_LAND)
                    * this.getKnightModifier()));
            knight.setOvertimeDmg(Math.round(Math.round(igniteOvertime * Constants.VOLCANIC_LAND)
                    * this.getKnightModifier()));
        } else {
            knight.takeDmg(Math.round(igniteDmg * this.getKnightModifier()));
        }
    }

    @Override
    public final void visit(final Pyromancer pyromancer) {
        pyromancer.setOvertimeType("ignite");
        pyromancer.setOvertimeDuration(Constants.IGNITE_ROUNDS);
        pyromancer.setOvertimeDmg(Math.round(igniteOvertime * this.getPyroModifier()));
        if (pyromancer.getPosition().equals('V')) {
            pyromancer.takeDmg(Math.round(igniteDmg * Constants.VOLCANIC_LAND
                    * this.getPyroModifier()));
            pyromancer.setOvertimeDmg(Math.round(igniteOvertime * this.getPyroModifier()
                    * Constants.VOLCANIC_LAND));
        } else {
            pyromancer.takeDmg(Math.round(igniteDmg * this.getPyroModifier()));
        }
    }

    @Override
    public final void visit(final Rogue rogue) {
        rogue.setOvertimeType("ignite");
        rogue.setOvertimeDuration(Constants.IGNITE_ROUNDS);
        rogue.setOvertimeDmg(Math.round(igniteOvertime * this.getRogueModifier()));
        if (rogue.getPosition().equals('V')) {
            rogue.takeDmg(Math.round(igniteDmg * Constants.VOLCANIC_LAND
                    * this.getRogueModifier()));
            rogue.setOvertimeDmg(Math.round(igniteOvertime * this.getRogueModifier()
                    * Constants.VOLCANIC_LAND));
        } else {
            rogue.takeDmg(Math.round(igniteDmg * this.getRogueModifier()));
        }
    }

    @Override
    public final void visit(final Wizard wizard) {
        wizard.setOvertimeType("ignite");
        wizard.setOvertimeDuration(Constants.IGNITE_ROUNDS);
        wizard.setOvertimeDmg(Math.round(igniteOvertime * this.getWizardModifier()));
        if (wizard.getPosition().equals('V')) {
            wizard.takeDmg(Math.round(igniteDmg * Constants.VOLCANIC_LAND
                    * this.getWizardModifier()));
            wizard.setOvertimeDmg(Math.round(igniteOvertime * this.getWizardModifier()
                    * Constants.VOLCANIC_LAND));
            wizard.addDamageDeflect(Math.round(igniteDmg * Constants.VOLCANIC_LAND));
        } else {
            wizard.takeDmg(Math.round(igniteDmg * this.getWizardModifier()));
            wizard.addDamageDeflect(Math.round(igniteDmg));
        }
    }

    // se imbunatatesc abilitatile daca nivelul eroului creste
    public final void levelUP() {
        setIgniteDmg(getIgniteDmg() + Constants.IGNITE_BASE_UP);
        setIgniteOvertime(getIgniteOvertime() + Constants.IGNITE_OVER_UP);
    }
}
