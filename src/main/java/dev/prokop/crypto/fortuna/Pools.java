package dev.prokop.crypto.fortuna;

import java.util.concurrent.atomic.AtomicLong;

public final class Pools {

    private final static Pools instance = new Pools();
    private final Pool[] pools = new Pool[32];
    private final AtomicLong eventCounter = new AtomicLong(0L);

    private Pools() {
        for (int i = 0; i < pools.length; i++)
            pools[i] = new Pool();
    }

    static Pools getInstance() {
        return instance;
    }

    void distribute(byte[] entropy) {
        pools[((int) eventCounter.getAndIncrement()) % pools.length].update(entropy);
    }

    Pool poolNo(int i) {
        return pools[i % pools.length];
    }

    @Override
    public String toString() {
        return "Pools{" +
                "eventCounter=" + eventCounter +
                '}';
    }

}
