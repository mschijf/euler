package euler.problem000.problem051_060

import euler.EulerExecutable
import java.lang.Exception
import java.math.BigInteger

class PowerfulDigitSum: EulerExecutable {

    override fun solve(): Any {
        val base = (1..99L).map { BigInteger.valueOf(it) }
        val powers = base.map{b -> (1..99).map{p -> b.pow(p)}}.flatten()
        val digitSum = powers.map{it.digitSum()}
        return digitSum.max()
    }

    private fun BigInteger.digitSum(): Int {
        return this.toString().sumOf { ch -> ch.digitToInt() }
    }
}
