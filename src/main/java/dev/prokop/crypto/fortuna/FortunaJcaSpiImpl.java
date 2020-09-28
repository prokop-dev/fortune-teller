package dev.prokop.crypto.fortuna;

import java.security.SecureRandomSpi;

public final class FortunaJcaSpiImpl extends SecureRandomSpi {

    private final Generator generator = Generator.getInstance();

    /**
     * This will post provided seed  to the entropy pools.
     * @param seed
     */
    @Override
    protected void engineSetSeed(byte[] seed) {
        Pools.getInstance().distribute(seed);
    }

    @Override
    protected void engineNextBytes(byte[] bytes) {
        generator.nextBytes(bytes);
    }

    @Override
    protected byte[] engineGenerateSeed(int numBytes) {
        final byte[] seed = new byte[numBytes];
        engineNextBytes(seed);
        return seed;
    }

}
