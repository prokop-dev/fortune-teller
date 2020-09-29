package dev.prokop.crypto.fortuna;

import dev.prokop.crypto.fortuna.entropy.NanoTimeEntropySource;
import dev.prokop.crypto.fortuna.entropy.StrongSecureRandomEntropySource;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public final class Accumulator {

    private static final Accumulator instance = new Accumulator();
    private final ThreadFactory daemonThreadFactory = runnable -> {
        final Thread thread = Executors.defaultThreadFactory().newThread(runnable);
        thread.setDaemon(true);
        return thread;
    };
    private final AtomicLong eventCounter = new AtomicLong(0L);
    private final AtomicLong bytesCounter = new AtomicLong(0L);

    public static Accumulator getInstance() {
        return instance;
    }

    private Accumulator() {
        addEntropySource(StrongSecureRandomEntropySource.getInstance());
        addEntropySource(new NanoTimeEntropySource());
    }

    public void addEntropySource(EntropySource entropySource) {
        Executors.newSingleThreadScheduledExecutor(daemonThreadFactory).scheduleWithFixedDelay(
                () -> {
                    final byte[] entropy = entropySource.entropy();
                    if (entropy != null && entropy.length > 0) {
                        Pools.getInstance().distribute(entropy);
                        eventCounter.incrementAndGet();
                        bytesCounter.addAndGet(entropy.length);
                    }
                },
                entropySource.initialDelay(), entropySource.delay(), TimeUnit.MILLISECONDS);
    }

    public long getEventCount() {
        return eventCounter.get();
    }

    public long getTotalEntropyBytesCount() {
        return bytesCounter.get();
    }

}