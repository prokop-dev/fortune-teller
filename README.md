# fortune-teller
Java Fortuna PRNG clean room implementation.
This implementation is JCA compatible.
This allow to use Fortuna as secure random number generator for all Java applications.

## Usage

Add Maven dependency

```xml
<dependency>
    <groupId>dev.prokop.crypto</groupId>
    <artifactId>fortune-teller</artifactId>
    <version>1.0.1</version>
</dependency>
```

Register JCA provider.

```java
Security.addProvider(new FortunaJcaProvider());
```

Request ```SecureRandom``` instance and generate some random numbers.

```java
final SecureRandom fortuna = SecureRandom.getInstance("Fortuna");

fortuna.generateSeed(22); // generates 22 random bytes

final byte[] bytes = new byte[1024];
fortuna.nextBytes(bytes); // fills byte array with 1 KiB of random data
```

That's it.

## Test it on your system

Don't trust what you read here, please test it on your system before use. Your mileage can vary. You have been warned.

```shell script
$ wget https://repo1.maven.org/maven2/dev/prokop/crypto/fortune-teller/1.0.1/fortune-teller-1.0.1.jar

$ java -cp fortune-teller-1.0.1.jar dev.prokop.crypto.fortuna.DieHarder | dieharder -g200 -a

#=============================================================================#
#            dieharder version 3.31.1 Copyright 2003 Robert G. Brown          #
#=============================================================================#
   rng_name    |rands/second|   Seed   |
stdin_input_raw|  4.12e+06  |3855428203|
#=============================================================================#
        test_name   |ntup| tsamples |psamples|  p-value |Assessment
#=============================================================================#
   diehard_birthdays|   0|       100|     100|0.92706545|  PASSED
      diehard_operm5|   0|   1000000|     100|0.89760746|  PASSED
  diehard_rank_32x32|   0|     40000|     100|0.28649369|  PASSED
    diehard_rank_6x8|   0|    100000|     100|0.83184980|  PASSED
   diehard_bitstream|   0|   2097152|     100|0.67206395|  PASSED
        diehard_opso|   0|   2097152|     100|0.58135346|  PASSED
...
```

Try to generate some images:

```shell script
java -cp fortune-teller-1.0.1.jar dev.prokop.crypto.fortuna.DieHarder | rawtoppm -rgb 256 256 > pixmap
cat pixmap | pnmtopng > random$(date +%Y%m%d%H%M%S).png
```

![Pretty dull, ha!](https://raw.githubusercontent.com/prokop-dev/fortune-teller/master/dieharder/random20201003134327.png)
