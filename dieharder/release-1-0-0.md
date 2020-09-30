# Testing Release 1.0.0

Results first. This was my first run of the dieharder test and here is the wow:

```
#=============================================================================#
#            dieharder version 3.31.1 Copyright 2003 Robert G. Brown          #
#=============================================================================#
   rng_name    |rands/second|   Seed   |
stdin_input_raw|  1.03e+06  |1279067521|
#=============================================================================#
        test_name   |ntup| tsamples |psamples|  p-value |Assessment
#=============================================================================#
   diehard_birthdays|   0|       100|     100|0.63253479|  PASSED
      diehard_operm5|   0|   1000000|     100|0.88092248|  PASSED
  diehard_rank_32x32|   0|     40000|     100|0.71382142|  PASSED
    diehard_rank_6x8|   0|    100000|     100|0.78306108|  PASSED
   diehard_bitstream|   0|   2097152|     100|0.94561780|  PASSED
        diehard_opso|   0|   2097152|     100|0.04891445|  PASSED
        diehard_oqso|   0|   2097152|     100|0.28241663|  PASSED
         diehard_dna|   0|   2097152|     100|0.13830591|  PASSED
diehard_count_1s_str|   0|    256000|     100|0.45694206|  PASSED
diehard_count_1s_byt|   0|    256000|     100|0.08831100|  PASSED
 diehard_parking_lot|   0|     12000|     100|0.76062712|  PASSED
    diehard_2dsphere|   2|      8000|     100|0.60843954|  PASSED
    diehard_3dsphere|   3|      4000|     100|0.99472929|  PASSED
     diehard_squeeze|   0|    100000|     100|0.96966957|  PASSED
        diehard_sums|   0|       100|     100|0.37261631|  PASSED
        diehard_runs|   0|    100000|     100|0.22742702|  PASSED
        diehard_runs|   0|    100000|     100|0.78094259|  PASSED
       diehard_craps|   0|    200000|     100|0.75576777|  PASSED
       diehard_craps|   0|    200000|     100|0.63208440|  PASSED
 marsaglia_tsang_gcd|   0|  10000000|     100|0.29046228|  PASSED
 marsaglia_tsang_gcd|   0|  10000000|     100|0.41656435|  PASSED
         sts_monobit|   1|    100000|     100|0.98767544|  PASSED
            sts_runs|   2|    100000|     100|0.97383997|  PASSED
          sts_serial|   1|    100000|     100|0.66813066|  PASSED
          sts_serial|   2|    100000|     100|0.37609013|  PASSED
          sts_serial|   3|    100000|     100|0.52890904|  PASSED
          sts_serial|   3|    100000|     100|0.75587200|  PASSED
          sts_serial|   4|    100000|     100|0.12702445|  PASSED
          sts_serial|   4|    100000|     100|0.06864849|  PASSED
          sts_serial|   5|    100000|     100|0.01614800|  PASSED
          sts_serial|   5|    100000|     100|0.26895164|  PASSED
          sts_serial|   6|    100000|     100|0.82204079|  PASSED
          sts_serial|   6|    100000|     100|0.28767424|  PASSED
          sts_serial|   7|    100000|     100|0.63563170|  PASSED
          sts_serial|   7|    100000|     100|0.31470780|  PASSED
          sts_serial|   8|    100000|     100|0.19670143|  PASSED
          sts_serial|   8|    100000|     100|0.11742793|  PASSED
          sts_serial|   9|    100000|     100|0.21392191|  PASSED
          sts_serial|   9|    100000|     100|0.02723761|  PASSED
          sts_serial|  10|    100000|     100|0.23652455|  PASSED
          sts_serial|  10|    100000|     100|0.93651329|  PASSED
          sts_serial|  11|    100000|     100|0.51011840|  PASSED
          sts_serial|  11|    100000|     100|0.37100399|  PASSED
          sts_serial|  12|    100000|     100|0.03263199|  PASSED
          sts_serial|  12|    100000|     100|0.24892002|  PASSED
          sts_serial|  13|    100000|     100|0.93106574|  PASSED
          sts_serial|  13|    100000|     100|0.13206616|  PASSED
          sts_serial|  14|    100000|     100|0.13224039|  PASSED
          sts_serial|  14|    100000|     100|0.07939200|  PASSED
          sts_serial|  15|    100000|     100|0.11323478|  PASSED
          sts_serial|  15|    100000|     100|0.39903518|  PASSED
          sts_serial|  16|    100000|     100|0.53762768|  PASSED
          sts_serial|  16|    100000|     100|0.38195011|  PASSED
         rgb_bitdist|   1|    100000|     100|0.19517111|  PASSED
         rgb_bitdist|   2|    100000|     100|0.11968573|  PASSED
         rgb_bitdist|   3|    100000|     100|0.13151311|  PASSED
         rgb_bitdist|   4|    100000|     100|0.12044663|  PASSED
         rgb_bitdist|   5|    100000|     100|0.76761141|  PASSED
         rgb_bitdist|   6|    100000|     100|0.07376546|  PASSED
         rgb_bitdist|   7|    100000|     100|0.80296326|  PASSED
         rgb_bitdist|   8|    100000|     100|0.86993021|  PASSED
         rgb_bitdist|   9|    100000|     100|0.92071351|  PASSED
         rgb_bitdist|  10|    100000|     100|0.16581370|  PASSED
         rgb_bitdist|  11|    100000|     100|0.38289303|  PASSED
         rgb_bitdist|  12|    100000|     100|0.43059187|  PASSED
rgb_minimum_distance|   2|     10000|    1000|0.70186340|  PASSED
rgb_minimum_distance|   3|     10000|    1000|0.51891564|  PASSED
rgb_minimum_distance|   4|     10000|    1000|0.85078136|  PASSED
rgb_minimum_distance|   5|     10000|    1000|0.23171144|  PASSED
    rgb_permutations|   2|    100000|     100|0.68401895|  PASSED
    rgb_permutations|   3|    100000|     100|0.60095482|  PASSED
    rgb_permutations|   4|    100000|     100|0.68039338|  PASSED
    rgb_permutations|   5|    100000|     100|0.69167487|  PASSED
      rgb_lagged_sum|   0|   1000000|     100|0.59062983|  PASSED
      rgb_lagged_sum|   1|   1000000|     100|0.23602314|  PASSED
      rgb_lagged_sum|   2|   1000000|     100|0.10869068|  PASSED
      rgb_lagged_sum|   3|   1000000|     100|0.51830374|  PASSED
      rgb_lagged_sum|   4|   1000000|     100|0.01561502|  PASSED
      rgb_lagged_sum|   5|   1000000|     100|0.76977314|  PASSED
      rgb_lagged_sum|   6|   1000000|     100|0.04648747|  PASSED
      rgb_lagged_sum|   7|   1000000|     100|0.77159847|  PASSED
      rgb_lagged_sum|   8|   1000000|     100|0.31611030|  PASSED
      rgb_lagged_sum|   9|   1000000|     100|0.10265000|  PASSED
      rgb_lagged_sum|  10|   1000000|     100|0.74450032|  PASSED
      rgb_lagged_sum|  11|   1000000|     100|0.38922938|  PASSED
      rgb_lagged_sum|  12|   1000000|     100|0.06198713|  PASSED
      rgb_lagged_sum|  13|   1000000|     100|0.39645954|  PASSED
      rgb_lagged_sum|  14|   1000000|     100|0.96158617|  PASSED
      rgb_lagged_sum|  15|   1000000|     100|0.53108237|  PASSED
      rgb_lagged_sum|  16|   1000000|     100|0.26367127|  PASSED
      rgb_lagged_sum|  17|   1000000|     100|0.11933869|  PASSED
      rgb_lagged_sum|  18|   1000000|     100|0.06187224|  PASSED
      rgb_lagged_sum|  19|   1000000|     100|0.78805081|  PASSED
      rgb_lagged_sum|  20|   1000000|     100|0.81426246|  PASSED
      rgb_lagged_sum|  21|   1000000|     100|0.36696751|  PASSED
      rgb_lagged_sum|  22|   1000000|     100|0.92236844|  PASSED
      rgb_lagged_sum|  23|   1000000|     100|0.86510107|  PASSED
      rgb_lagged_sum|  24|   1000000|     100|0.93692383|  PASSED
      rgb_lagged_sum|  25|   1000000|     100|0.80841125|  PASSED
      rgb_lagged_sum|  26|   1000000|     100|0.05475000|  PASSED
      rgb_lagged_sum|  27|   1000000|     100|0.90121181|  PASSED
      rgb_lagged_sum|  28|   1000000|     100|0.80020582|  PASSED
      rgb_lagged_sum|  29|   1000000|     100|0.74143099|  PASSED
      rgb_lagged_sum|  30|   1000000|     100|0.57159238|  PASSED
      rgb_lagged_sum|  31|   1000000|     100|0.95513526|  PASSED
      rgb_lagged_sum|  32|   1000000|     100|0.71417819|  PASSED
     rgb_kstest_test|   0|     10000|    1000|0.86868502|  PASSED
     dab_bytedistrib|   0|  51200000|       1|0.49195850|  PASSED
             dab_dct| 256|     50000|       1|0.26220415|  PASSED
Preparing to run test 207.  ntuple = 0
        dab_filltree|  32|  15000000|       1|0.57401879|  PASSED
        dab_filltree|  32|  15000000|       1|0.39291836|  PASSED
Preparing to run test 208.  ntuple = 0
       dab_filltree2|   0|   5000000|       1|0.38735013|  PASSED
       dab_filltree2|   1|   5000000|       1|0.26175880|  PASSED
Preparing to run test 209.  ntuple = 0
        dab_monobit2|  12|  65000000|       1|0.31813231|  PASSED
```

How did I test?

```java
    // java -cp fortune-teller-1.0.0.jar DieHard | dieharder -g200 -a
    public static void main(String...args) throws Exception {
        Security.addProvider(new FortunaJcaProvider());
        final SecureRandom fortuna = SecureRandom.getInstance("Fortuna");
        fortuna.generateSeed(32);
        Thread.sleep(5000);

        while (true) {
            byte[] bytes = fortuna.generateSeed(1024);
            System.out.write(bytes);
            System.out.flush();
        }
    }
```

Test environment:
 - Windows 10
 - WLS 2
 - Debian
 - Open JRE

I'm going to experiment a bit with Accumulator to understand what caused the results above.
Very likely my experiments will result in subsequent release.