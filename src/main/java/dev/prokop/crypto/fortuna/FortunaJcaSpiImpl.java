package dev.prokop.crypto.fortuna;

import java.security.SecureRandomSpi;

public final class FortunaJcaSpiImpl extends SecureRandomSpi {

    /**
     * This will post provided seed to the entropy pools.
     * @param seed a byte array that will be used as extra entropy and distributed among entropy pools
     */
    @Override
    protected void engineSetSeed(byte[] seed) {
        Pools.getInstance().distribute(seed);
    }

    @Override
    protected void engineNextBytes(byte[] bytes) {
        Generator.getInstance().nextBytes(bytes);
    }

    @Override
    protected byte[] engineGenerateSeed(int numBytes) {
        final byte[] seed = new byte[numBytes];
        engineNextBytes(seed);
        return seed;
    }

}
