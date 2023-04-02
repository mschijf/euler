package euler.problem000.problem031_040

import tool.math.Fraction
import euler.EulerExecutable

class DigitCancellingFractions: EulerExecutable {
    override fun solve(): Any {
        val list = (11..98)
            .map{numerator -> (numerator+1..99)
                .filter { it % 10 != 0 }
                .map {denominator -> Pair(inexperienceNormalizedFraction(numerator,denominator), Fraction(numerator, denominator)) }
                .filter {it.first == it.second}
            }.flatten()
            .map{it.first}

        return list.reduce { acc, fraction ->  acc*fraction }
    }

    private fun inexperienceNormalizedFraction(numerator: Int, denominator: Int): Fraction {
        val numFirst = numerator / 10
        val numSec = numerator % 10
        val denFirst = denominator / 10
        val denSec = denominator % 10

        return when {
            numFirst == denFirst -> Fraction(numSec, denSec)
            numFirst == denSec -> Fraction(numSec, denFirst)
            numSec == denFirst -> Fraction(numFirst, denSec)
            numSec == denSec -> Fraction(numFirst, denFirst)
            else -> Fraction(0,0)
        }
    }
}