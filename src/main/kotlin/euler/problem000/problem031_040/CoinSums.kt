package euler.problem000.problem031_040

import euler.EulerExecutable

class CoinSums: EulerExecutable {
    override val problemNumber = 31

    private val coinList = listOf(1, 2, 5, 10, 20, 50, 100, 200)

    override fun solve(): Any {
        return countCoinConfiguration(200)
    }

    private fun countCoinConfiguration(amount: Int, lastCoinUsed: Int=0) : Int {
        return if (amount == 0)
            1
        else {
            coinList
                .filter { coin -> (coin <= amount) && (coin >= lastCoinUsed) }
                .sumOf { coin -> countCoinConfiguration(amount - coin, coin) }
        }
    }
}