package euler.problem000.problem021_030

import euler.execute

fun main() {
    execute(21) { amicableNumbers() }
    execute(22) { namesScores() }
//    execute(23) { nonAbundantSums() }
    execute(24) { lexicographicPermutations() }
    execute(25) { indexOf1000DigitFibonacciNumber() }
    execute(26) { reciprocalCycles() }

    val eulerProjectList = listOf(
        QuadraticPrimes::class,
        NumberSpiralDiagonals::class,
        DistinctPowers::class,
        DigitFifthPowers::class,
    )
    eulerProjectList.forEach { execute(it) }
}

