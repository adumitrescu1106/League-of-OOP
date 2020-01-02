package abilities;

import champions.Knight;
import champions.Pyromancer;
import champions.Rogue;
import helpers.Constants;

public class Deflect extends Ability implements Visitor {
    private float deflectPercent;

    public Deflect() {
        this.deflectPercent = Constants.DEFLECT_PERCENT;
    }

    public final float getDeflectPercent() {
        return deflectPercent;
    }

    public final void setDeflectPercent(final float deflectPercent) {
        this.deflectPercent = deflectPercent;
    }
    // se imbunatatesc abilitatile daca nivelul eroului creste
    public final void levelUP() {
        setDeflectPercent(getDeflectPercent() + Constants.DEFLECT_UP);
    }

    public final void visit(final Knight knight) {
        if (knight.getPosition().equals('D')) {
            knight.takeDmg(Math.round(deflectPercent * Constants.DESERT_LAND
                    * Constants.DEFLECT_KNIGHT * knight.getdamageDeflect()));
        } else {
            knight.takeDmg(Math.round(deflectPercent
                    * Constants.DEFLECT_KNIGHT * knight.getdamageDeflect()));
        }
    }

    public final void visit(final Pyromancer pyromancer) {
        if (pyromancer.getPosition().equals('D')) {
            pyromancer.takeDmg(Math.round(deflectPercent * Constants.DESERT_LAND
                    * Constants.DEFLECT_PYRO * pyromancer.getdamageDeflect()));
        } else {
            pyromancer.takeDmg(Math.round(deflectPercent
                    * Constants.DEFLECT_PYRO * pyromancer.getdamageDeflect()));
        }
    }

    public final void visit(final Rogue rogue) {
        if (rogue.getPosition().equals('D')) {
            rogue.takeDmg(Math.round(deflectPercent * Constants.DESERT_LAND
                    * Constants.DEFLECT_ROGUE * rogue.getdamageDeflect()));
        } else {
            rogue.takeDmg(Math.round(deflectPercent
                    * Constants.DEFLECT_ROGUE * rogue.getdamageDeflect()));
        }
    }

}
