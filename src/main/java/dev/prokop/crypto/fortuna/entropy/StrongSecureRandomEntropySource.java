package dev.prokop.crypto.fortuna.entropy;

import dev.prokop.crypto.fortuna.EntropySource;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class StrongSecureRandomEntropySource implements EntropySource {

    private static final StrongSecureRandomEntropySource instance = new StrongSecureRandomEntropySource();
    private final SecureRandom secureRandom;

    public static StrongSecureRandomEntropySource getInstance() {
        return instance;
    }

    private StrongSecureRandomEntropySource() {
        try {
            secureRandom = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError("Unable get strong entropy source", e);
        }
    }

    @Override
    public byte[] entropy() {
        return secureRandom.generateSeed(32);
    }

    @Override
    public long initialDelay() {
        return 0L;
    }

    @Override
    public long delay() {
        return 100L;
    }
}