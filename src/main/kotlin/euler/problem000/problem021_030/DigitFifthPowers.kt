package euler.problem000.problem021_030

import euler.EulerExecutable

class DigitFifthPowers: EulerExecutable {
    override fun solve(): Any {
        return (2..1_000_000).filter{it.sumOfPowers(5) == it}.sum()
    }

    private fun Int.sumOfPowers(power: Int): Int {
        var sum = 0
        var base = this
        while (base > 0) {
            val digit = base % 10
            sum += digit.power(power)
            base /= 10
        }
        return sum
    }

    private fun Int.power(power: Int): Int {
        var x = 1
        repeat (power) {
            x *= this
        }
        return x
    }
}