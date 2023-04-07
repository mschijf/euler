package euler.problem000.problem061_070

import euler.execute

fun main() {
    val startProblemNumber = 61

    val classList = listOf(
        CyclicalFigurateNumbers::class,
        CubicPermutations::class,
//        CombinatoricSelections::class,
//        PokerHands::class,
//        LychrelNumbers::class,
//        PowerfulDigitSum::class,
//        SquareRootConvergents::class,
//        SpiralPrimes::class,
//        XOR_Decryption::class,
//        PrimePairSets::class
    )

    classList.forEachIndexed { index, kClass -> execute(startProblemNumber+index, kClass) }
}

