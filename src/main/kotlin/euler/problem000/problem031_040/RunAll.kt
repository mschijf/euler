package euler.problem000.problem031_040

import euler.execute

fun main() {
    val startProblemNumber = 31
    val classList = listOf(
        CoinSums::class,
        PandigitalProducts::class,
        DigitCancellingFractions::class,
        DigitFactorials::class,
        CircularPrimes::class,
        DoubleBasePalindromes::class,
        TruncatablePrimes::class,
        PandigitalMultiples::class,
        IntegerRightTriangles::class,
        ChampernownesConstant::class
    )

    classList.forEachIndexed { index, kClass -> execute(startProblemNumber+index, kClass) }
}

