package dev.prokop.crypto.fortuna;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.concurrent.atomic.AtomicLong;

public final class Pools {

    private final static Pools instance = new Pools();
    private final Pool[] pools = new Pool[32];
    private final AtomicLong eventCounter = new AtomicLong(0L);
    private final AtomicLong totalEntropyBytes = new AtomicLong(0L);

    private Pools() {
        for (int i = 0; i < pools.length; i++) pools[i] = new Pool();
        init();
    }

    static Pools getInstance() {
        return instance;
    }

    public void distribute(byte[] entropy) {
        pools[((int) eventCounter.getAndIncrement()) % pools.length].update(entropy);
        totalEntropyBytes.addAndGet(entropy.length);
    }

    Pool poolNo(int i) {
        return pools[i % pools.length];
    }

    private void init() {
        final SecureRandom secureRandom = new SecureRandom();
        for (int i = 0; i < pools.length; i++) distribute(secureRandom.generateSeed(32));

        try {
            final SecureRandom strongInstance = SecureRandom.getInstanceStrong();
            for (int i = 0; i < pools.length; i++) distribute(strongInstance.generateSeed(32));
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Unable to use SecureRandom.getInstanceStrong() to initialize Fortuna");
        }
    }

    @Override
    public String toString() {
        return "Pools{" +
                "eventCounter=" + eventCounter +
                ", totalEntropyBytes=" + totalEntropyBytes +
                '}';
    }
}