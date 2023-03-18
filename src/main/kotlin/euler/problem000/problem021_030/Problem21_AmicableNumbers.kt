package euler.problem000.problem021_030

import tool.math.sumOfProperDivisors

fun amicableNumbers(): Any {
    var sum = 0
    for (i in 1 until 10_000) {
        val pd = i.sumOfProperDivisors()
        if (pd.sumOfProperDivisors() == i && i < pd) {
            sum += (i + pd)
        }
    }
    return sum
}

//31626
