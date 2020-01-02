package abilities;

import champions.Knight;
import champions.Pyromancer;
import champions.Rogue;
import champions.Wizard;

public interface Visitor {
    // interfata care permite instantelor de tip abilitate sa afecteze
    // instantele de tip campion
    void visit(Knight knight);
    void visit(Pyromancer pyromancer);
    void visit(Rogue rogue);
    void visit(Wizard wizard);
}
