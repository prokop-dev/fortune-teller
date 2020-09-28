package dev.prokop.crypto.fortuna;

import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;

import static org.junit.jupiter.api.Assertions.*;

class FortunaJcaProviderTest {

    @Test
    void addition() throws NoSuchAlgorithmException {
        final int position = Security.addProvider(new FortunaJcaProvider());
        System.out.println("Fortuna provider added on position: " + position);
        assertTrue(position >= 0);

        final SecureRandom fortuna = SecureRandom.getInstance("Fortuna");
        assertNotNull(fortuna);
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