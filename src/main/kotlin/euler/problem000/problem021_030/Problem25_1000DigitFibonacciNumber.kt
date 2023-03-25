package euler.problem000.problem021_030

import euler.EulerExecutable
import java.math.BigInteger

class IndexOf1000DigitFibonacciNumber: EulerExecutable {

    override fun solve(): Any {
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
}
