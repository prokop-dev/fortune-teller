# Testing Release 1.0.1

This release added proper DieHarder stream generator with the ```main()``` method entry point.

Testing quality of entropy collection can be rewarding and educational activity. I run couple of rounds of ```dieharder```.

#### 1 Every dieharder test passed!

The results below uses only single ```EntropySource``` - the ```NanoTimeEntropySource```.
This entropy source collects least significant byte of ```System.nanoTim()``` in this way:

```java
    @Override
    public byte[] entropy() {
        final byte[] bytes = {
                (byte) System.nanoTime(), (byte) System.nanoTime(), (byte) System.nanoTime(), (byte) System.nanoTime(),
                (byte) System.nanoTime(), (byte) System.nanoTime(), (byte) System.nanoTime(), (byte) System.nanoTime(),
                (byte) System.nanoTime(), (byte) System.nanoTime(), (byte) System.nanoTime(), (byte) System.nanoTime(),
                (byte) System.nanoTime(), (byte) System.nanoTime(), (byte) System.nanoTime(), (byte) System.nanoTime(),
                (byte) System.nanoTime(), (byte) System.nanoTime(), (byte) System.nanoTime(), (byte) System.nanoTime(),
                (byte) System.nanoTime(), (byte) System.nanoTime(), (byte) System.nanoTime(), (byte) System.nanoTime(),
                (byte) System.nanoTime(), (byte) System.nanoTime(), (byte) System.nanoTime(), (byte) System.nanoTime(),
                (byte) System.nanoTime(), (byte) System.nanoTime(), (byte) System.nanoTime(), (byte) System.nanoTime(),
        };
        return bytes;
    }
```

That entropy (and nothing else) is feed into the Accumulator. Results are below. They are fantastic.
I was really surprised that above method of collecting entropy is both so cheap and so effective.

```
java -cp fortune-teller-1.0.1.jar dev.prokop.crypto.fortuna.DieHarder | dieharder -g200 -a

#=============================================================================#
#            dieharder version 3.31.1 Copyright 2003 Robert G. Brown          #
#=============================================================================#
   rng_name    |rands/second|   Seed   |
stdin_input_raw|  2.12e+06  |2558668138|
#=============================================================================#
        test_name   |ntup| tsamples |psamples|  p-value |Assessment
#=============================================================================#
   diehard_birthdays|   0|       100|     100|0.56073698|  PASSED
      diehard_operm5|   0|   1000000|     100|0.36352405|  PASSED
  diehard_rank_32x32|   0|     40000|     100|0.96604430|  PASSED
    diehard_rank_6x8|   0|    100000|     100|0.74187496|  PASSED
   diehard_bitstream|   0|   2097152|     100|0.82872861|  PASSED
        diehard_opso|   0|   2097152|     100|0.67484649|  PASSED
        diehard_oqso|   0|   2097152|     100|0.77323859|  PASSED
         diehard_dna|   0|   2097152|     100|0.18255631|  PASSED
diehard_count_1s_str|   0|    256000|     100|0.34330684|  PASSED
diehard_count_1s_byt|   0|    256000|     100|0.59505722|  PASSED
 diehard_parking_lot|   0|     12000|     100|0.71266869|  PASSED
    diehard_2dsphere|   2|      8000|     100|0.78447547|  PASSED
    diehard_3dsphere|   3|      4000|     100|0.83463822|  PASSED
     diehard_squeeze|   0|    100000|     100|0.74751217|  PASSED
        diehard_sums|   0|       100|     100|0.67928543|  PASSED
        diehard_runs|   0|    100000|     100|0.29614235|  PASSED
        diehard_runs|   0|    100000|     100|0.31044731|  PASSED
       diehard_craps|   0|    200000|     100|0.51950955|  PASSED
       diehard_craps|   0|    200000|     100|0.24347043|  PASSED
 marsaglia_tsang_gcd|   0|  10000000|     100|0.15352221|  PASSED
 marsaglia_tsang_gcd|   0|  10000000|     100|0.21745379|  PASSED
         sts_monobit|   1|    100000|     100|0.99067206|  PASSED
            sts_runs|   2|    100000|     100|0.25302651|  PASSED
          sts_serial|   1|    100000|     100|0.22565624|  PASSED
          sts_serial|   2|    100000|     100|0.27665637|  PASSED
          sts_serial|   3|    100000|     100|0.34667144|  PASSED
          sts_serial|   3|    100000|     100|0.93685757|  PASSED
          sts_serial|   4|    100000|     100|0.42621359|  PASSED
          sts_serial|   4|    100000|     100|0.78190033|  PASSED
          sts_serial|   5|    100000|     100|0.74463019|  PASSED
          sts_serial|   5|    100000|     100|0.24110717|  PASSED
          sts_serial|   6|    100000|     100|0.88061582|  PASSED
          sts_serial|   6|    100000|     100|0.91286234|  PASSED
          sts_serial|   7|    100000|     100|0.15675983|  PASSED
          sts_serial|   7|    100000|     100|0.08676752|  PASSED
          sts_serial|   8|    100000|     100|0.93116184|  PASSED
          sts_serial|   8|    100000|     100|0.07779107|  PASSED
          sts_serial|   9|    100000|     100|0.41039999|  PASSED
          sts_serial|   9|    100000|     100|0.53931946|  PASSED
          sts_serial|  10|    100000|     100|0.27040818|  PASSED
          sts_serial|  10|    100000|     100|0.47752579|  PASSED
          sts_serial|  11|    100000|     100|0.89362225|  PASSED
          sts_serial|  11|    100000|     100|0.96553591|  PASSED
          sts_serial|  12|    100000|     100|0.98071586|  PASSED
          sts_serial|  12|    100000|     100|0.83629040|  PASSED
          sts_serial|  13|    100000|     100|0.65820235|  PASSED
          sts_serial|  13|    100000|     100|0.72367277|  PASSED
          sts_serial|  14|    100000|     100|0.92890120|  PASSED
          sts_serial|  14|    100000|     100|0.48172273|  PASSED
          sts_serial|  15|    100000|     100|0.97571436|  PASSED
          sts_serial|  15|    100000|     100|0.97425010|  PASSED
          sts_serial|  16|    100000|     100|0.47766096|  PASSED
          sts_serial|  16|    100000|     100|0.35301385|  PASSED
         rgb_bitdist|   1|    100000|     100|0.60695455|  PASSED
         rgb_bitdist|   2|    100000|     100|0.75644402|  PASSED
         rgb_bitdist|   3|    100000|     100|0.18396425|  PASSED
         rgb_bitdist|   4|    100000|     100|0.00871455|  PASSED
         rgb_bitdist|   5|    100000|     100|0.91172178|  PASSED
         rgb_bitdist|   6|    100000|     100|0.14121616|  PASSED
         rgb_bitdist|   7|    100000|     100|0.08519881|  PASSED
         rgb_bitdist|   8|    100000|     100|0.89108192|  PASSED
         rgb_bitdist|   9|    100000|     100|0.78271856|  PASSED
         rgb_bitdist|  10|    100000|     100|0.85747775|  PASSED
         rgb_bitdist|  11|    100000|     100|0.70336801|  PASSED
         rgb_bitdist|  12|    100000|     100|0.44581208|  PASSED
rgb_minimum_distance|   2|     10000|    1000|0.63161387|  PASSED
rgb_minimum_distance|   3|     10000|    1000|0.65672625|  PASSED
rgb_minimum_distance|   4|     10000|    1000|0.78458526|  PASSED
rgb_minimum_distance|   5|     10000|    1000|0.34288262|  PASSED
    rgb_permutations|   2|    100000|     100|0.85069313|  PASSED
    rgb_permutations|   3|    100000|     100|0.42695446|  PASSED
    rgb_permutations|   4|    100000|     100|0.42241370|  PASSED
    rgb_permutations|   5|    100000|     100|0.21358332|  PASSED
      rgb_lagged_sum|   0|   1000000|     100|0.45536534|  PASSED
      rgb_lagged_sum|   1|   1000000|     100|0.53944915|  PASSED
      rgb_lagged_sum|   2|   1000000|     100|0.77797907|  PASSED
      rgb_lagged_sum|   3|   1000000|     100|0.67767120|  PASSED
      rgb_lagged_sum|   4|   1000000|     100|0.95310125|  PASSED
      rgb_lagged_sum|   5|   1000000|     100|0.78297941|  PASSED
      rgb_lagged_sum|   6|   1000000|     100|0.47007135|  PASSED
      rgb_lagged_sum|   7|   1000000|     100|0.42961478|  PASSED
      rgb_lagged_sum|   8|   1000000|     100|0.98670998|  PASSED
      rgb_lagged_sum|   9|   1000000|     100|0.49584945|  PASSED
      rgb_lagged_sum|  10|   1000000|     100|0.70415519|  PASSED
      rgb_lagged_sum|  11|   1000000|     100|0.65182157|  PASSED
      rgb_lagged_sum|  12|   1000000|     100|0.78456548|  PASSED
      rgb_lagged_sum|  13|   1000000|     100|0.72765552|  PASSED
      rgb_lagged_sum|  14|   1000000|     100|0.93820187|  PASSED
      rgb_lagged_sum|  15|   1000000|     100|0.42630845|  PASSED
      rgb_lagged_sum|  16|   1000000|     100|0.75684351|  PASSED
      rgb_lagged_sum|  17|   1000000|     100|0.96811116|  PASSED
      rgb_lagged_sum|  18|   1000000|     100|0.90244813|  PASSED
      rgb_lagged_sum|  19|   1000000|     100|0.91626810|  PASSED
      rgb_lagged_sum|  20|   1000000|     100|0.84545535|  PASSED
      rgb_lagged_sum|  21|   1000000|     100|0.48800968|  PASSED
      rgb_lagged_sum|  22|   1000000|     100|0.32998219|  PASSED
      rgb_lagged_sum|  23|   1000000|     100|0.87847585|  PASSED
      rgb_lagged_sum|  24|   1000000|     100|0.86249321|  PASSED
      rgb_lagged_sum|  25|   1000000|     100|0.62430961|  PASSED
      rgb_lagged_sum|  26|   1000000|     100|0.91448353|  PASSED
      rgb_lagged_sum|  27|   1000000|     100|0.90985095|  PASSED
      rgb_lagged_sum|  28|   1000000|     100|0.70680808|  PASSED
      rgb_lagged_sum|  29|   1000000|     100|0.13290393|  PASSED
      rgb_lagged_sum|  30|   1000000|     100|0.79721808|  PASSED
      rgb_lagged_sum|  31|   1000000|     100|0.42404310|  PASSED
      rgb_lagged_sum|  32|   1000000|     100|0.58356629|  PASSED
     rgb_kstest_test|   0|     10000|    1000|0.85775184|  PASSED
     dab_bytedistrib|   0|  51200000|       1|0.51903039|  PASSED
             dab_dct| 256|     50000|       1|0.52771208|  PASSED
Preparing to run test 207.  ntuple = 0
        dab_filltree|  32|  15000000|       1|0.72388911|  PASSED
        dab_filltree|  32|  15000000|       1|0.21404524|  PASSED
Preparing to run test 208.  ntuple = 0
       dab_filltree2|   0|   5000000|       1|0.56710805|  PASSED
       dab_filltree2|   1|   5000000|       1|0.26184132|  PASSED
Preparing to run test 209.  ntuple = 0
        dab_monobit2|  12|  65000000|       1|0.79957354|  PASSED
```

### 2 SecureRandom strongInstance does not fare that well

It is also a bit unexpected.

```
#=============================================================================#
#            dieharder version 3.31.1 Copyright 2003 Robert G. Brown          #
#=============================================================================#
   rng_name    |rands/second|   Seed   |
stdin_input_raw|  1.76e+06  |2804856633|
#=============================================================================#
        test_name   |ntup| tsamples |psamples|  p-value |Assessment
#=============================================================================#
   diehard_birthdays|   0|       100|     100|0.91711867|  PASSED
      diehard_operm5|   0|   1000000|     100|0.91825203|  PASSED
  diehard_rank_32x32|   0|     40000|     100|0.26114093|  PASSED
    diehard_rank_6x8|   0|    100000|     100|0.91051313|  PASSED
   diehard_bitstream|   0|   2097152|     100|0.78800738|  PASSED
        diehard_opso|   0|   2097152|     100|0.70005356|  PASSED
        diehard_oqso|   0|   2097152|     100|0.64534517|  PASSED
         diehard_dna|   0|   2097152|     100|0.50540159|  PASSED
diehard_count_1s_str|   0|    256000|     100|0.41449993|  PASSED
diehard_count_1s_byt|   0|    256000|     100|0.03004688|  PASSED
 diehard_parking_lot|   0|     12000|     100|0.04779345|  PASSED
    diehard_2dsphere|   2|      8000|     100|0.78773460|  PASSED
    diehard_3dsphere|   3|      4000|     100|0.89615887|  PASSED
     diehard_squeeze|   0|    100000|     100|0.67609560|  PASSED
        diehard_sums|   0|       100|     100|0.00837291|  PASSED
        diehard_runs|   0|    100000|     100|0.09574462|  PASSED
        diehard_runs|   0|    100000|     100|0.66700424|  PASSED
       diehard_craps|   0|    200000|     100|0.34632139|  PASSED
       diehard_craps|   0|    200000|     100|0.54800717|  PASSED
 marsaglia_tsang_gcd|   0|  10000000|     100|0.62357857|  PASSED
 marsaglia_tsang_gcd|   0|  10000000|     100|0.93752816|  PASSED
         sts_monobit|   1|    100000|     100|0.63272733|  PASSED
            sts_runs|   2|    100000|     100|0.61134703|  PASSED
          sts_serial|   1|    100000|     100|0.53570137|  PASSED
          sts_serial|   2|    100000|     100|0.43169234|  PASSED
          sts_serial|   3|    100000|     100|0.59914964|  PASSED
          sts_serial|   3|    100000|     100|0.21456447|  PASSED
          sts_serial|   4|    100000|     100|0.39875508|  PASSED
          sts_serial|   4|    100000|     100|0.74496463|  PASSED
          sts_serial|   5|    100000|     100|0.99496354|  PASSED
          sts_serial|   5|    100000|     100|0.49383844|  PASSED
          sts_serial|   6|    100000|     100|0.88773241|  PASSED
          sts_serial|   6|    100000|     100|0.74373505|  PASSED
          sts_serial|   7|    100000|     100|0.46362121|  PASSED
          sts_serial|   7|    100000|     100|0.98257494|  PASSED
          sts_serial|   8|    100000|     100|0.75272612|  PASSED
          sts_serial|   8|    100000|     100|0.78470669|  PASSED
          sts_serial|   9|    100000|     100|0.21595045|  PASSED
          sts_serial|   9|    100000|     100|0.42738206|  PASSED
          sts_serial|  10|    100000|     100|0.84428097|  PASSED
          sts_serial|  10|    100000|     100|0.37447091|  PASSED
          sts_serial|  11|    100000|     100|0.99975888|   WEAK
          sts_serial|  11|    100000|     100|0.73359358|  PASSED
          sts_serial|  12|    100000|     100|0.91106472|  PASSED
          sts_serial|  12|    100000|     100|0.44516533|  PASSED
          sts_serial|  13|    100000|     100|0.55596433|  PASSED
          sts_serial|  13|    100000|     100|0.41096804|  PASSED
          sts_serial|  14|    100000|     100|0.21087430|  PASSED
          sts_serial|  14|    100000|     100|0.01160682|  PASSED
          sts_serial|  15|    100000|     100|0.11821673|  PASSED
          sts_serial|  15|    100000|     100|0.41226650|  PASSED
          sts_serial|  16|    100000|     100|0.24307205|  PASSED
          sts_serial|  16|    100000|     100|0.65581791|  PASSED
         rgb_bitdist|   1|    100000|     100|0.94569286|  PASSED
         rgb_bitdist|   2|    100000|     100|0.97406488|  PASSED
         rgb_bitdist|   3|    100000|     100|0.78586442|  PASSED
         rgb_bitdist|   4|    100000|     100|0.93009342|  PASSED
         rgb_bitdist|   5|    100000|     100|0.96551382|  PASSED
         rgb_bitdist|   6|    100000|     100|0.95430864|  PASSED
         rgb_bitdist|   7|    100000|     100|0.33091285|  PASSED
         rgb_bitdist|   8|    100000|     100|0.78327772|  PASSED
         rgb_bitdist|   9|    100000|     100|0.10251796|  PASSED
         rgb_bitdist|  10|    100000|     100|0.55166515|  PASSED
         rgb_bitdist|  11|    100000|     100|0.49681409|  PASSED
         rgb_bitdist|  12|    100000|     100|0.41392387|  PASSED
rgb_minimum_distance|   2|     10000|    1000|0.00227617|   WEAK
rgb_minimum_distance|   3|     10000|    1000|0.93683312|  PASSED
rgb_minimum_distance|   4|     10000|    1000|0.97167287|  PASSED
rgb_minimum_distance|   5|     10000|    1000|0.26807824|  PASSED
    rgb_permutations|   2|    100000|     100|0.14595153|  PASSED
    rgb_permutations|   3|    100000|     100|0.32922425|  PASSED
    rgb_permutations|   4|    100000|     100|0.76259880|  PASSED
    rgb_permutations|   5|    100000|     100|0.17750386|  PASSED
      rgb_lagged_sum|   0|   1000000|     100|0.03345749|  PASSED
      rgb_lagged_sum|   1|   1000000|     100|0.59795110|  PASSED
      rgb_lagged_sum|   2|   1000000|     100|0.36561004|  PASSED
      rgb_lagged_sum|   3|   1000000|     100|0.19887084|  PASSED
      rgb_lagged_sum|   4|   1000000|     100|0.52722727|  PASSED
      rgb_lagged_sum|   5|   1000000|     100|0.39994180|  PASSED
      rgb_lagged_sum|   6|   1000000|     100|0.88780622|  PASSED
      rgb_lagged_sum|   7|   1000000|     100|0.80559925|  PASSED
      rgb_lagged_sum|   8|   1000000|     100|0.67700725|  PASSED
      rgb_lagged_sum|   9|   1000000|     100|0.11004305|  PASSED
      rgb_lagged_sum|  10|   1000000|     100|0.64331272|  PASSED
      rgb_lagged_sum|  11|   1000000|     100|0.11710759|  PASSED
      rgb_lagged_sum|  12|   1000000|     100|0.94703787|  PASSED
      rgb_lagged_sum|  13|   1000000|     100|0.71240400|  PASSED
      rgb_lagged_sum|  14|   1000000|     100|0.27155289|  PASSED
      rgb_lagged_sum|  15|   1000000|     100|0.29065719|  PASSED
      rgb_lagged_sum|  16|   1000000|     100|0.03567083|  PASSED
      rgb_lagged_sum|  17|   1000000|     100|0.61403092|  PASSED
      rgb_lagged_sum|  18|   1000000|     100|0.53096787|  PASSED
      rgb_lagged_sum|  19|   1000000|     100|0.62567186|  PASSED
      rgb_lagged_sum|  20|   1000000|     100|0.32636551|  PASSED
      rgb_lagged_sum|  21|   1000000|     100|0.39739903|  PASSED
      rgb_lagged_sum|  22|   1000000|     100|0.11643446|  PASSED
      rgb_lagged_sum|  23|   1000000|     100|0.88679677|  PASSED
      rgb_lagged_sum|  24|   1000000|     100|0.64943315|  PASSED
      rgb_lagged_sum|  25|   1000000|     100|0.20820767|  PASSED
      rgb_lagged_sum|  26|   1000000|     100|0.72189012|  PASSED
      rgb_lagged_sum|  27|   1000000|     100|0.59581361|  PASSED
      rgb_lagged_sum|  28|   1000000|     100|0.77970293|  PASSED
      rgb_lagged_sum|  29|   1000000|     100|0.14951171|  PASSED
      rgb_lagged_sum|  30|   1000000|     100|0.59577430|  PASSED
      rgb_lagged_sum|  31|   1000000|     100|0.31054365|  PASSED
      rgb_lagged_sum|  32|   1000000|     100|0.74623793|  PASSED
     rgb_kstest_test|   0|     10000|    1000|0.30610244|  PASSED
     dab_bytedistrib|   0|  51200000|       1|0.20266716|  PASSED
             dab_dct| 256|     50000|       1|0.45616547|  PASSED
Preparing to run test 207.  ntuple = 0
        dab_filltree|  32|  15000000|       1|0.40213034|  PASSED
        dab_filltree|  32|  15000000|       1|0.85201640|  PASSED
Preparing to run test 208.  ntuple = 0
       dab_filltree2|   0|   5000000|       1|0.66854836|  PASSED
       dab_filltree2|   1|   5000000|       1|0.32315550|  PASSED
Preparing to run test 209.  ntuple = 0
        dab_monobit2|  12|  65000000|       1|0.58466914|  PASSED
```

### 3 Do we need entropy to pass dieharder tests?

No entropy feed at all. No single ```EntropySource``` is running. Accumulator is on the extreme diet.
This means internal key reseeds periodically as per Fortuna algorithm, but always with ```"".sha256()``` value.
This does not mean that output is predictable and deterministic... How?
I have implemented reseeding based on timing (e.g. every 100 ms) or generation of 1MB of data.
During constant generation of pseudorandom data, counter will increment in pace that is not synchronized
with time defined reseeds.

So even pooling empty entropy triggers ```.digest()``` method followed by ```.update(...)``` method call.
The ```.update(...)``` takes seed material.
While entropy is 100% predictable, the moment when it is mixed into internal generator seed is not.
While this might not provide full recovery of generator, it reflects the genius of Fortuna designers.

```
#=============================================================================#
#            dieharder version 3.31.1 Copyright 2003 Robert G. Brown          #
#=============================================================================#
   rng_name    |rands/second|   Seed   |
stdin_input_raw|  4.20e+06  |3465852931|
#=============================================================================#
        test_name   |ntup| tsamples |psamples|  p-value |Assessment
#=============================================================================#
   diehard_birthdays|   0|       100|     100|0.48561361|  PASSED
      diehard_operm5|   0|   1000000|     100|0.49599298|  PASSED
  diehard_rank_32x32|   0|     40000|     100|0.51432407|  PASSED
    diehard_rank_6x8|   0|    100000|     100|0.20897374|  PASSED
   diehard_bitstream|   0|   2097152|     100|0.79330093|  PASSED
        diehard_opso|   0|   2097152|     100|0.35530483|  PASSED
        diehard_oqso|   0|   2097152|     100|0.99773643|   WEAK
         diehard_dna|   0|   2097152|     100|0.81860274|  PASSED
diehard_count_1s_str|   0|    256000|     100|0.43309986|  PASSED
diehard_count_1s_byt|   0|    256000|     100|0.25315158|  PASSED
 diehard_parking_lot|   0|     12000|     100|0.17940638|  PASSED
    diehard_2dsphere|   2|      8000|     100|0.97052998|  PASSED
    diehard_3dsphere|   3|      4000|     100|0.19431330|  PASSED
     diehard_squeeze|   0|    100000|     100|0.64814703|  PASSED
        diehard_sums|   0|       100|     100|0.06920783|  PASSED
        diehard_runs|   0|    100000|     100|0.43838470|  PASSED
        diehard_runs|   0|    100000|     100|0.12588440|  PASSED
       diehard_craps|   0|    200000|     100|0.39807676|  PASSED
       diehard_craps|   0|    200000|     100|0.59565504|  PASSED
 marsaglia_tsang_gcd|   0|  10000000|     100|0.98147297|  PASSED
 marsaglia_tsang_gcd|   0|  10000000|     100|0.98713483|  PASSED
         sts_monobit|   1|    100000|     100|0.53889960|  PASSED
            sts_runs|   2|    100000|     100|0.70149480|  PASSED
          sts_serial|   1|    100000|     100|0.13366438|  PASSED
          sts_serial|   2|    100000|     100|0.58192653|  PASSED
          sts_serial|   3|    100000|     100|0.39235785|  PASSED
          sts_serial|   3|    100000|     100|0.63958889|  PASSED
          sts_serial|   4|    100000|     100|0.69001340|  PASSED
          sts_serial|   4|    100000|     100|1.00000000|  FAILED
          sts_serial|   5|    100000|     100|0.02002154|  PASSED
          sts_serial|   5|    100000|     100|0.03795748|  PASSED
          sts_serial|   6|    100000|     100|0.00681403|  PASSED
          sts_serial|   6|    100000|     100|0.06690180|  PASSED
          sts_serial|   7|    100000|     100|0.09325016|  PASSED
          sts_serial|   7|    100000|     100|0.87040990|  PASSED
          sts_serial|   8|    100000|     100|0.00136919|   WEAK
          sts_serial|   8|    100000|     100|0.23889736|  PASSED
          sts_serial|   9|    100000|     100|0.09635769|  PASSED
          sts_serial|   9|    100000|     100|0.25931977|  PASSED
          sts_serial|  10|    100000|     100|0.51269974|  PASSED
          sts_serial|  10|    100000|     100|0.63694858|  PASSED
          sts_serial|  11|    100000|     100|0.70331545|  PASSED
          sts_serial|  11|    100000|     100|0.69732448|  PASSED
          sts_serial|  12|    100000|     100|0.98777402|  PASSED
          sts_serial|  12|    100000|     100|0.33513558|  PASSED
          sts_serial|  13|    100000|     100|0.73413410|  PASSED
          sts_serial|  13|    100000|     100|0.87279136|  PASSED
          sts_serial|  14|    100000|     100|0.66191947|  PASSED
          sts_serial|  14|    100000|     100|0.31688014|  PASSED
          sts_serial|  15|    100000|     100|0.83452381|  PASSED
          sts_serial|  15|    100000|     100|0.28429309|  PASSED
          sts_serial|  16|    100000|     100|0.80649404|  PASSED
          sts_serial|  16|    100000|     100|0.48937541|  PASSED
         rgb_bitdist|   1|    100000|     100|0.78253213|  PASSED
         rgb_bitdist|   2|    100000|     100|0.96891072|  PASSED
         rgb_bitdist|   3|    100000|     100|0.37043870|  PASSED
         rgb_bitdist|   4|    100000|     100|0.16544181|  PASSED
         rgb_bitdist|   5|    100000|     100|0.49327433|  PASSED
         rgb_bitdist|   6|    100000|     100|0.45811660|  PASSED
         rgb_bitdist|   7|    100000|     100|0.72475673|  PASSED
         rgb_bitdist|   8|    100000|     100|0.06378874|  PASSED
         rgb_bitdist|   9|    100000|     100|0.75447682|  PASSED
         rgb_bitdist|  10|    100000|     100|0.77906807|  PASSED
         rgb_bitdist|  11|    100000|     100|0.68857446|  PASSED
         rgb_bitdist|  12|    100000|     100|0.22149750|  PASSED
rgb_minimum_distance|   2|     10000|    1000|0.71628711|  PASSED
rgb_minimum_distance|   3|     10000|    1000|0.22353499|  PASSED
rgb_minimum_distance|   4|     10000|    1000|0.78953967|  PASSED
rgb_minimum_distance|   5|     10000|    1000|0.57158797|  PASSED
    rgb_permutations|   2|    100000|     100|0.73875703|  PASSED
    rgb_permutations|   3|    100000|     100|0.61737155|  PASSED
    rgb_permutations|   4|    100000|     100|0.01822699|  PASSED
    rgb_permutations|   5|    100000|     100|0.34230104|  PASSED
      rgb_lagged_sum|   0|   1000000|     100|0.42498903|  PASSED
      rgb_lagged_sum|   1|   1000000|     100|0.24123177|  PASSED
      rgb_lagged_sum|   2|   1000000|     100|0.89510618|  PASSED
      rgb_lagged_sum|   3|   1000000|     100|0.17540962|  PASSED
      rgb_lagged_sum|   4|   1000000|     100|0.66854648|  PASSED
      rgb_lagged_sum|   5|   1000000|     100|0.29537633|  PASSED
      rgb_lagged_sum|   6|   1000000|     100|0.47285234|  PASSED
      rgb_lagged_sum|   7|   1000000|     100|0.52038414|  PASSED
      rgb_lagged_sum|   8|   1000000|     100|0.93710571|  PASSED
      rgb_lagged_sum|   9|   1000000|     100|0.15100663|  PASSED
      rgb_lagged_sum|  10|   1000000|     100|0.42145471|  PASSED
      rgb_lagged_sum|  11|   1000000|     100|0.40811384|  PASSED
      rgb_lagged_sum|  12|   1000000|     100|0.19742781|  PASSED
      rgb_lagged_sum|  13|   1000000|     100|0.82183912|  PASSED
      rgb_lagged_sum|  14|   1000000|     100|0.11645144|  PASSED
      rgb_lagged_sum|  15|   1000000|     100|0.03747724|  PASSED
      rgb_lagged_sum|  16|   1000000|     100|0.62725412|  PASSED
      rgb_lagged_sum|  17|   1000000|     100|0.42125623|  PASSED
      rgb_lagged_sum|  18|   1000000|     100|0.13325279|  PASSED
      rgb_lagged_sum|  19|   1000000|     100|0.20700560|  PASSED
      rgb_lagged_sum|  20|   1000000|     100|0.93039607|  PASSED
      rgb_lagged_sum|  21|   1000000|     100|0.96466474|  PASSED
      rgb_lagged_sum|  22|   1000000|     100|0.63593221|  PASSED
      rgb_lagged_sum|  23|   1000000|     100|0.53770467|  PASSED
      rgb_lagged_sum|  24|   1000000|     100|0.31239305|  PASSED
      rgb_lagged_sum|  25|   1000000|     100|0.02569889|  PASSED
      rgb_lagged_sum|  26|   1000000|     100|0.92679845|  PASSED
      rgb_lagged_sum|  27|   1000000|     100|0.04123084|  PASSED
      rgb_lagged_sum|  28|   1000000|     100|0.37972602|  PASSED
      rgb_lagged_sum|  29|   1000000|     100|0.68041316|  PASSED
      rgb_lagged_sum|  30|   1000000|     100|0.10928299|  PASSED
      rgb_lagged_sum|  31|   1000000|     100|0.94384264|  PASSED
      rgb_lagged_sum|  32|   1000000|     100|0.32107701|  PASSED
     rgb_kstest_test|   0|     10000|    1000|0.03785914|  PASSED
     dab_bytedistrib|   0|  51200000|       1|0.68706217|  PASSED
             dab_dct| 256|     50000|       1|0.85043879|  PASSED
Preparing to run test 207.  ntuple = 0
        dab_filltree|  32|  15000000|       1|0.69260127|  PASSED
        dab_filltree|  32|  15000000|       1|0.77232265|  PASSED
Preparing to run test 208.  ntuple = 0
       dab_filltree2|   0|   5000000|       1|0.49516058|  PASSED
       dab_filltree2|   1|   5000000|       1|0.96843106|  PASSED
Preparing to run test 209.  ntuple = 0
        dab_monobit2|  12|  65000000|       1|0.78987728|  PASSED
```

I bet that if I fancied to run it few more times, I would be lucky to get all test pass thanks to difference in timing.