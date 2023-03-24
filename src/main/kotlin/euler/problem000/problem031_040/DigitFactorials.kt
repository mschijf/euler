package euler.problem000.problem031_040

import euler.EulerExecutable
import tool.math.fac

class DigitFactorials: EulerExecutable {
    override val problemNumber = 34

    override fun solve(): Any {
//        return (3..7*9.fac().toInt()).filter { it == it.digitFactorialSum() }.sum()
        return (3..7*9.fac().toInt())
            .filter { it == it.sumOfdigit { fac().toInt() }}
            .sum()
    }

    private fun Int.sumOfdigit(digitFunction: Int.() -> Int):Int {
        var base = this
        var sum = 0
        while (base != 0) {
            sum += (base % 10).digitFunction()
            base /= 10
        }
        return sum
    }
}