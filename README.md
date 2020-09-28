# fortune-teller
Java Fortune PRNG clean room implementation.

## Usage

Add Maven dependency

```xml
<dependency>
    <groupId>dev.prokop.crypto</groupId>
    <artifactId>fortune-teller</artifactId>
    <version>1.0.0</version>
</dependency>
```

Register JCA provider.

```java
Security.addProvider(new FortunaJcaProvider());
```

request ```SecureRancom``` instance and generate some random numbers.

```java
final SecureRandom fortuna = SecureRandom.getInstance("Fortuna");

fortuna.generateSeed(22); // generates 22 random bytes

final byte[] bytes = new byte[1024];
fortuna.nextBytes(bytes); // fills byte array with 1 KiB of random data
```