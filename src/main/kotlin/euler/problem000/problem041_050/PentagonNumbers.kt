package euler.problem000.problem041_050

import euler.EulerExecutable
import tool.math.isPentagonal
import tool.math.isPrime
import tool.math.makeAllPermutations
import kotlin.math.max
import kotlin.math.min
import kotlin.math.sqrt

class PentagonNumbers: EulerExecutable {

    override fun solve(): Any {
        val maxNumber = 3000
        val pentagonNumberList = (1..maxNumber).map{n -> n*(3*n-1)/2}
        val pentagonNumberSet = pentagonNumberList.toSet()
        var bestDiff = 999_999_999
        for (i in 0 until maxNumber-1) {
            for (j in i + 1 until maxNumber) {
                val sum = (pentagonNumberList[i] + pentagonNumberList[j])
                if (sum > pentagonNumberList.last())
                    break
                val diff = (pentagonNumberList[j] - pentagonNumberList[i])
                if (sum in pentagonNumberSet && diff in pentagonNumberSet) {
//                    println("${pentagonNumberList[i]} and ${pentagonNumberList[j]}")
//                    println("${pentagonNumberList[j] - pentagonNumberList[i]}")
                    bestDiff = min(bestDiff, diff)
                }
            }
        }
        return bestDiff
    }
}