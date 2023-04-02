package euler.problem000.problem051_060

import euler.EulerExecutable
import tool.math.BigFraction
import tool.math.log10
import java.math.BigInteger

class SquareRootConvergents: EulerExecutable {

    private val fractionList = List(1000) { BigFraction(BigInteger.ONE, BigInteger.TWO) }

    override fun solve(): Any {
        return fractionList
            .scan(BigFraction(BigInteger.ONE, BigInteger.TWO)){ acc, _ -> BigFraction(BigInteger.ONE) / (acc + BigInteger.TWO)}
            .map{it + BigInteger.ONE}
            .count {it.numerator.toString().length > it.denominator.toString().length}
    }

}
