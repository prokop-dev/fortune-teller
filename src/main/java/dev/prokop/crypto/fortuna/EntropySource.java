package dev.prokop.crypto.fortuna;

public interface EntropySource {

    byte[] entropy();

    long initialDelay();

    long delay();
}
