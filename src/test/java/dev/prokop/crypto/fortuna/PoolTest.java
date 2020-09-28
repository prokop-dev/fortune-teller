package dev.prokop.crypto.fortuna;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PoolTest {

    @Test
    void getString() {
        final Pool pool = new Pool();

        final String s1 = Arrays.toString(pool.entropy());
        System.out.println(s1);
        final String s2 = Arrays.toString(pool.entropy());
        System.out.println(s2);
        final String s3 = Arrays.toString(pool.entropy());
        System.out.println(s3);
        final String s4 = Arrays.toString(pool.entropy());
        System.out.println(s4);
        final String s5 = Arrays.toString(pool.entropy());
        System.out.println(s5);

        assertNotEquals(s1, s2);
        assertNotEquals(s2, s3);
        assertNotEquals(s3, s4);
        assertNotEquals(s4, s5);
    }
}