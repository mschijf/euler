package euler.problem000.problem021_030

import euler.execute

fun main() {
    val startProblemNumber = 21

    val eulerProjectList = listOf(
        AmicableNumbers::class,
        NamesScores::class,
        NonAbundantSums::class,
        LexicographicPermutations::class,
        IndexOf1000DigitFibonacciNumber::class,
        ReciprocalCycles::class,
        QuadraticPrimes::class,
        NumberSpiralDiagonals::class,
        DistinctPowers::class,
        DigitFifthPowers::class,
    )
    eulerProjectList.forEachIndexed { index, kClass ->  execute(startProblemNumber+index, kClass) }
}