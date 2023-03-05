---
description: Clean Room Java (JCA compatible) Fortuna PRNG implementation.
---

# Fortune Teller

FORTUNA PRNG (Pseudorandom Number Generator) is a cryptographically secure random number generator designed to produce unpredictable and statistically random output. FORTUNA PRNG was developed by Niels Ferguson and Bruce Schneier, two experts in the field of cryptography, and was published in 2003.

FORTUNA PRNG is designed to be both fast and secure, and is suitable for use in a wide range of applications that require secure random numbers, such as in generating cryptographic keys, salts, and nonces.

The FORTUNA PRNG works by gathering entropy from a variety of sources, such as mouse movements, keyboard timings, and other system events, and then using that entropy to seed a set of cryptographically secure pseudorandom number generators. These generators are then used to produce the random output.

One of the key features of FORTUNA PRNG is that it has a built-in mechanism for reseeding the generators. This means that if the entropy input to the generators is ever compromised or becomes too predictable, FORTUNA will automatically reseed itself with fresh entropy, ensuring that the output remains unpredictable and secure.

FORTUNA PRNG has been thoroughly analyzed and has been shown to be a strong and secure random number generator, making it a popular choice for use in security-critical applications.
