package euler.problem000.problem031_040

import euler.EulerExecutable
import tool.math.getPrimeList

class TruncatablePrimes: EulerExecutable {

    private val primeSet = getPrimeList(1_000_000).toSet()

    override fun solve(): Any {
        return primeSet
            .filter{ it > 9}
            .filter { it.toString().isTruncatablePrime() }
            .sum()
    }

    private fun String.isTruncatablePrime() : Boolean {
        return (1..this.length).all { this.take(it).toInt() in primeSet && this.takeLast(it).toInt() in primeSet }
    }

}