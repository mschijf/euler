package euler.problem000.problem051_060

import euler.execute

fun main() {
    val startProblemNumber = 51

    val classList = listOf(
        PrimeDigitReplacements::class,
//        CodedTriangleNumbers::class,
//        SubStringDivisibility::class,
//        PentagonNumbers::class,
//        TriangularPentagonalHexagonal::class,
//        GoldbachsOtherConjecture::class,
//        DistinctPrimesFactors::class,
//        SelfPowers::class,
//        PrimePermutations::class,
//        ConsecutivePrimeSum::class
    )

    classList.forEachIndexed { index, kClass -> execute(startProblemNumber+index, kClass) }
}

