package euler.problem000.problem031_040

import euler.EulerExecutable
import tool.math.getPrimeList

class CircularPrimes: EulerExecutable {
    private val primeList = getPrimeList(1_000_000).toSet()

    override fun solve(): Any {
        return primeList.count { it.isCircularPrime() }
    }

    private fun Int.isCircularPrime(): Boolean {
        var s = this.toString()
        repeat(s.length) {
            s = s.substring(1) + s.take(1)
            if (s.toInt() !in primeList)
                return false
        }
        return true
    }

}