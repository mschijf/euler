package euler.problem000.problem041_050

import euler.execute

fun main() {
    val startProblemNumber = 41

    val classList = listOf(
        PandigitalPrime::class,
        CodedTriangleNumbers::class,
        SubStringDivisibility::class,
        PentagonNumbers::class,
        TriangularPentagonalHexagonal::class,
        GoldbachsOtherConjecture::class,
        DistinctPrimesFactors::class,
        SelfPowers::class,
        PrimePermutations::class,
    )

    classList.forEachIndexed { index, kClass -> execute(startProblemNumber+index, kClass) }
}

