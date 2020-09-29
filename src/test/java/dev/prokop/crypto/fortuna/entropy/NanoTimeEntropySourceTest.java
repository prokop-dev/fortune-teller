package dev.prokop.crypto.fortuna.entropy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NanoTimeEntropySourceTest {

    @Test
    void entropy() {
        assertEquals(32, new NanoTimeEntropySource().entropy().length);
    }
}