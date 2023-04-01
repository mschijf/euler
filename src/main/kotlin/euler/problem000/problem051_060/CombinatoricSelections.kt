package euler.problem000.problem051_060

import euler.EulerExecutable
import kotlin.math.max

class CombinatoricSelections: EulerExecutable {

    override fun solve(): Any {
        val xx =  (1..100).map { n -> (1..n).map{ r -> Pair(n, r) } }.flatten()
        val yy = xx.filter{ combinationBiggerThanMillion(it.first, it.second) }
        return yy.count()
    }

    private fun combinationBiggerThanMillion(n: Int, r: Int): Boolean {
        val maxValue = 1_000_000

        val max = max(r, n-r)
        val numeratorFactors = (max+1..n).toMutableList()
        val denominatorFactors = (1..n-max).toMutableList()

        var tmp = 1.0
        while (denominatorFactors.isNotEmpty()) {
            if (numeratorFactors.isNotEmpty() && tmp < maxValue) {
                tmp *= numeratorFactors.removeFirst()
            } else {
                tmp /= denominatorFactors.removeLast()
            }
        }
        while (numeratorFactors.isNotEmpty() && tmp < maxValue) {
            tmp *= numeratorFactors.removeLast()
        }
        return tmp >= maxValue
    }
}