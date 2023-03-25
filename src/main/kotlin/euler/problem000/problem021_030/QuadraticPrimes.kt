package euler.problem000.problem021_030

import euler.EulerExecutable
import tool.math.getPrimeList

class QuadraticPrimes: EulerExecutable {
    private val primeSet = getPrimeList(100_000).toSet() + 1

    override fun solve(): Any {
        val aRange = -999..999
        val bRange = -1000 .. 1000

        val best = 
            aRange
                .map { a -> bRange.map { b-> Triple(a,b, consecutivePrimeSerieLength(a, b)) } }
                .flatten()
                .maxBy{it.third}
        return best.first * best.second
    }

    private fun consecutivePrimeSerieLength(a: Int, b: Int): Int {
        var n = 0
        while ((n*n + a*n + b) in primeSet) {
            n++
        }
        return n
    }
}

