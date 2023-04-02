package euler.problem000.problem051_060

import euler.execute

fun main() {
    val startProblemNumber = 51

    val classList = listOf(
        PrimeDigitReplacements::class,
        PermutedMultiples::class,
        CombinatoricSelections::class,
        PokerHands::class,
        LychrelNumbers::class,
        PowerfulDigitSum::class,
        SquareRootConvergents::class,
        SpiralPrimes::class,
//        PrimePermutations::class,
//        ConsecutivePrimeSum::class
    )

    classList.forEachIndexed { index, kClass -> execute(startProblemNumber+index, kClass) }
}

