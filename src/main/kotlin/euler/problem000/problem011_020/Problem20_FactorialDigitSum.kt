package euler.problem000.problem011_020

import java.math.BigInteger

fun factorialDigitSum(): Any {
    var bn = BigInteger.valueOf(1)
    repeat (100) {factor ->
        bn *= BigInteger.valueOf((factor+1).toLong())

    // line below is a trick to keep the number a bit smaller: divide by ten, to ignore trailing 0's
    // nevertheless, still too big to fit in a 64-bit Long. So I still needed the BigInteger
    //        while (bn.mod(BigInteger.valueOf(10)) == BigInteger.ZERO) bn /= BigInteger.valueOf(10)
    }
    return bn.toString().sumOf {it.digitToInt()}

}

