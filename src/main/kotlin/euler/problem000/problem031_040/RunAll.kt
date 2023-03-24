package euler.problem000.problem031_040

import euler.execute

fun main() {
    val eulerProjectList = listOf(
        CoinSums(),
        PandigitalProducts(),
        DigitCancellingFractions(),
        DigitFactorials()
    )
    eulerProjectList.forEach { execute(it) }
}

