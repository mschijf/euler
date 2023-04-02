package euler.problem000.problem051_060

import euler.EulerExecutable
import tool.math.isPrime

class SpiralPrimes: EulerExecutable {

    override fun solve(): Any {
        var primeCount = 0
        var totalCount = 1
        var n = 1
        do {
            n += 2
            totalCount += 4
            primeCount += listOf(n*n, n*n-(n-1), n*n-2*(n-1), n*n-3*(n-1)).count{it.isPrime()}
        } while (10*primeCount > totalCount)
        return n
    }

}
