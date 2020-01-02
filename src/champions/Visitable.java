package champions;

import abilities.Visitor;

public interface Visitable {
    // interfata care permite vizitarea campionilor de catre abilitati
    void accept(Visitor v);
}
