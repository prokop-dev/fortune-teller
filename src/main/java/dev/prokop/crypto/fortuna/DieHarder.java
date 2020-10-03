package dev.prokop.crypto.fortuna;

/**
 * Entry point. This allows to run stream generation that will facilitate testing
 * this Fortuna implementation with dieharder tests.
 */
public class DieHarder {

    public static void main(String...args) throws Exception {
        final Generator instance = Generator.getInstance();

        while (true) {
            final byte[] bytes = new byte[1024];
            instance.nextBytes(bytes);
            System.out.write(bytes);
            System.out.flush();
        }
    }

}
