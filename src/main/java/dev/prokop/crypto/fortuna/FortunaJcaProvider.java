package dev.prokop.crypto.fortuna;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.Provider;

public final class FortunaJcaProvider extends Provider {

    public FortunaJcaProvider() {
        super("Fortuna", 1.0, "Fortuna provider v1.0, implementing " +
                "Fortuna Pseudo Random Number Generator.");

        AccessController.doPrivileged(new PrivilegedAction() {
            public Object run() {
                setup();
                return null;
            }
        });
    }

    private void setup() {

    }
}
