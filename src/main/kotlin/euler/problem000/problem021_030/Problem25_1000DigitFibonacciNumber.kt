package euler.problem000.problem021_030

import java.math.BigInteger

fun indexOf1000DigitFibonacciNumber(): Any {
    var f1 = BigInteger.ONE
    var f2 = BigInteger.ONE
    var index = 2
    while (f2.toString().length < 1000) {
        val f3 = f2 + f1
        f1 = f2
        f2 = f3
        index++
    }
    return index
}
