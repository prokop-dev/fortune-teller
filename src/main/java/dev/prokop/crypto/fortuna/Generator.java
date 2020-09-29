package dev.prokop.crypto.fortuna;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class Generator {

    private static final Generator instance = new Generator();
    private final MessageDigest messageDigest;
    private final Rijndael rijndael = new Rijndael();
    private final byte[] plainText = new byte[16];
    private final byte[] cipherText = plainText.clone();
    private int capacity = 0; // how many random bytes left in cipherTest
    private long reseedCounter = 0L;
    private long blocksGenerated = 0L;
    private long lastTimeReseeded = 0L;

    private Generator() {
        try {
            messageDigest = MessageDigest.getInstance("SHA-256", "SUN");
        } catch (NoSuchAlgorithmException | NoSuchProviderException e) {
            throw new AssertionError("Unable to create SHA-256 digester.", e);
        }

        while (Accumulator.getInstance().getEventCount() < 32) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException interruptedException) {
                throw new AssertionError("Generator might not be properly seeded.");
            }
        }
    }

    static Generator getInstance() {
        return instance;
    }

    void nextBytes(byte[] bytes) {
        int bytesLeft = bytes.length;
        while (bytesLeft > 0) {
            if (capacity == 0) newBlock();
            int chunkSize = bytesLeft > capacity ? capacity : bytesLeft;
            System.arraycopy(cipherText, cipherText.length - capacity,
                    bytes, bytes.length - bytesLeft, chunkSize);
            bytesLeft -= chunkSize;
            capacity -= chunkSize;
        }
    }

    private void newBlock() {
        if ((blocksGenerated++ % (1024L * 1024 / 16)) == 0)
            reseed(); // reseed every 1MiB
        if (System.currentTimeMillis() - lastTimeReseeded > 100L)
            reseed(); // reseed if more than 100 ms from last reseed

        incrementCounter();
        rijndael.encrypt(plainText, cipherText);
        capacity = cipherText.length;
    }

    private void incrementCounter() {
        byte newValue, pos = 0;
        do newValue = ++plainText[pos++]; while (newValue == 0 && pos < plainText.length);
    }

    private void reseed() {
        long powerOfTwo = 1;
        for (int i = 0; i < 32; i++) {
            if (reseedCounter % powerOfTwo == 0) {
                messageDigest.update(Pools.getInstance().poolNo(i).entropy());
            }
            powerOfTwo <<= 1;
        }

        final byte[] digest = messageDigest.digest();
        rijndael.makeKey(digest, digest.length * 8, Rijndael.DIR_ENCRYPT);
        messageDigest.update(digest);

        reseedCounter++;
        lastTimeReseeded = System.currentTimeMillis();
    }

}