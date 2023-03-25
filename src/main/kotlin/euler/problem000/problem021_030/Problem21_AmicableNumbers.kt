package euler.problem000.problem021_030

import euler.EulerExecutable
import tool.math.sumOfProperDivisors

class AmicableNumbers: EulerExecutable {
    override fun solve(): Any {
        var sum = 0
        for (i in 1 until 10_000) {
            val pd = i.sumOfProperDivisors()
            if (pd.sumOfProperDivisors() == i && i < pd) {
                sum += (i + pd)
            }
        }
        return sum
    }
}

//31626
