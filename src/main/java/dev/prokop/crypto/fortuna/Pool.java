package dev.prokop.crypto.fortuna;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.concurrent.locks.ReentrantLock;

public class Pool {

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
        } finally {
            lock.unlock();
        }
    }

    byte[] entropy() {
        lock.lock();
        try {
            final byte[] digest = messageDigest.digest(); // take entropy snapshot
            messageDigest.update(digest); // don't waste entropy, keep it accumulated
            return digest;
        } finally {
            lock.unlock();
        }
    }

}