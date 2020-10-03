package dev.prokop.crypto.fortuna;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Arrays;

class GeneratorTest {

    @Test
    void nextBytes() throws NoSuchAlgorithmException, InterruptedException, IOException {
        Security.addProvider(new FortunaJcaProvider());
        final SecureRandom fortuna = SecureRandom.getInstance("Fortuna");
        Thread.sleep(5000);

        final byte[] bytes = new byte[25];
        fortuna.nextBytes(bytes);
        System.out.println(Arrays.toString(bytes));
    }
}