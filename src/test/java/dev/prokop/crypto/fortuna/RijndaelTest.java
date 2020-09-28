package dev.prokop.crypto.fortuna;

import org.junit.jupiter.api.Test;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

import static org.junit.jupiter.api.Assertions.*;

class RijndaelTest {

    private final SecureRandom secureRandom = new SecureRandom();
    private final byte[] key = secureRandom.generateSeed(32);

    @Test
    void encrypt() throws Exception {
        final Rijndael rijndael = new Rijndael();
        rijndael.makeKey(key, 256, Rijndael.DIR_ENCRYPT);

        byte[] cipherText = new byte[16];
        rijndael.encrypt("1234567890123456".getBytes(), cipherText);

        final Cipher aes = Cipher.getInstance("AES/ECB/NoPadding");
        aes.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, "AES"));
        byte[] plainText = aes.doFinal(cipherText);

        assertArrayEquals("1234567890123456".getBytes(), plainText);
    }

    @Test
    void decrypt() throws Exception {
        final Cipher aes = Cipher.getInstance("AES/ECB/NoPadding");
        aes.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key, "AES"));

        byte[] cipherText = aes.doFinal("1234567890123456".getBytes());
        byte[] plainText = cipherText.clone();

        final Rijndael rijndael = new Rijndael();
        rijndael.makeKey(key, 256, Rijndael.DIR_DECRYPT);
        rijndael.decrypt(cipherText, plainText);

        assertArrayEquals("1234567890123456".getBytes(), plainText);
    }

}