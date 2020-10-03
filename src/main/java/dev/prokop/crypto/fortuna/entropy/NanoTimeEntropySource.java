package dev.prokop.crypto.fortuna.entropy;

import dev.prokop.crypto.fortuna.EntropySource;

public class NanoTimeEntropySource implements EntropySource {

    @Override
    public byte[] entropy() {
        final byte[] bytes = {
                (byte) System.nanoTime(), (byte) System.nanoTime(), (byte) System.nanoTime(), (byte) System.nanoTime(),
                (byte) System.nanoTime(), (byte) System.nanoTime(), (byte) System.nanoTime(), (byte) System.nanoTime(),
                (byte) System.nanoTime(), (byte) System.nanoTime(), (byte) System.nanoTime(), (byte) System.nanoTime(),
                (byte) System.nanoTime(), (byte) System.nanoTime(), (byte) System.nanoTime(), (byte) System.nanoTime(),
                (byte) System.nanoTime(), (byte) System.nanoTime(), (byte) System.nanoTime(), (byte) System.nanoTime(),
                (byte) System.nanoTime(), (byte) System.nanoTime(), (byte) System.nanoTime(), (byte) System.nanoTime(),
                (byte) System.nanoTime(), (byte) System.nanoTime(), (byte) System.nanoTime(), (byte) System.nanoTime(),
                (byte) System.nanoTime(), (byte) System.nanoTime(), (byte) System.nanoTime(), (byte) System.nanoTime(),
        };
        return bytes;
    }

    @Override
    public long initialDelay() {
        return 250L;
    }

    @Override
    public long delay() {
        return 50L;
    }
}
