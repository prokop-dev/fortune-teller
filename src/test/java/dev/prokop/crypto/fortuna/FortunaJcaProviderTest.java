package dev.prokop.crypto.fortuna;

import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FortunaJcaProviderTest {

    @Test
    void addition() throws NoSuchAlgorithmException {
        final int position = Security.addProvider(new FortunaJcaProvider());
        System.out.println("Fortuna provider added on position: " + position);
        assertTrue(position >= 0);

        final SecureRandom fortuna = SecureRandom.getInstance("Fortuna");
        assertNotNull(fortuna);
        fortuna.generateSeed(22); // generates 22 random bytes

        final byte[] bytes = new byte[1024];
        fortuna.nextBytes(bytes); // fills byte array with 1 KiB of random data
    }

    @Test
    void allProviders() {
        final Provider[] providers = Security.getProviders();
        assertTrue(providers.length > 0);
        System.out.println("All providers:");
        int count = 0;
        for (Provider provider : providers) {
            System.out.println(++count + ". " + provider + ", " + provider.getName());
        }
    }

}