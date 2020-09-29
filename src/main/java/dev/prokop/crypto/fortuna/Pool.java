package dev.prokop.crypto.fortuna;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

public class Pool {

    private final AtomicLong size = new AtomicLong(0L);
    private final AtomicLong sizeSinceLastUse = new AtomicLong(0L);
    private final AtomicInteger usageCounter = new AtomicInteger(0);
    private final MessageDigest messageDigest;
    private final ReentrantLock lock = new ReentrantLock();

    Pool() {
        try {
            messageDigest = MessageDigest.getInstance("SHA-256", "SUN");
        } catch (NoSuchAlgorithmException | NoSuchProviderException e) {
            throw new AssertionError("Unable to create SHA-256 digester.", e);
        }
    }

    void update(byte[] entropy) {
        lock.lock();
        try {
            messageDigest.update(entropy);
            size.addAndGet(entropy.length);
            sizeSinceLastUse.addAndGet(entropy.length);
        } finally {
            lock.unlock();
        }
    }

    byte[] entropy() {
        byte[] digest;

        lock.lock();
        try {
            digest = messageDigest.digest();
            messageDigest.update(digest);
            usageCounter.incrementAndGet();
            sizeSinceLastUse.set(0L);
        } finally {
            lock.unlock();
        }

        return digest;
    }

    @Override
    public String toString() {
        return "Pool{" +
                "size=" + size +
                ", sizeSinceLastUse=" + sizeSinceLastUse +
                ", usageCounter=" + usageCounter +
                '}';
    }

}
