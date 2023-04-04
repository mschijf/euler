package euler.problem000.problem051_060

import euler.EulerExecutable
import tool.math.digitLength
import tool.math.getPrimeList
import tool.math.isPrime
import tool.math.pow
import kotlin.math.min

class PrimePairSets: EulerExecutable {

    private val primeList = getPrimeList(10_000)

    override fun solve(): Any {
        return solveRec(5)
    }

    //
    // flink gereduceerd naar onderstaan algoritme
    // idee: doorloop alle 5 tallen van een gegeven set van priemgetallen
    // check per toegevoegd priemgetal of het nog een priemPaar is met de vorige reeds gekozen
    // eenmaal vijf gekozen, (die dus alle vijf priemparen van elkaar zijn) bepaal dan de som

    private fun solveRec(nrsToGo: Int, primes: List<Int> = emptyList(), start:Int=0): Int {
        if (nrsToGo == 0)
            return primes.sum()
        var minSum = 999_999_999
        for (i in start until primeList.size-nrsToGo-1) {
            val p = primeList[i]
            if (primes.all { it.primePair(p) }) {
                minSum = min(minSum, solveRec(nrsToGo - 1, primes + p, i + 1))
            }
        }
        return minSum
    }

    private fun Int.primePair(other: Int): Boolean {
        val x10 = 10.pow(this.digitLength()).toInt()
        val y10 = 10.pow(other.digitLength()).toInt()

        val a = x10*other + this
        val b = y10*this + other

        return a.isPrime() && b.isPrime()
    }

}

//
//18176
//29712
//3528
//60