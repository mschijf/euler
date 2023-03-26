package euler.problem000.problem041_050

import euler.EulerExecutable
import tool.math.getPrimeList

class ConsecutivePrimeSum: EulerExecutable {

    private val primeList = getPrimeList(1_000_000)
    private val primeSet = primeList.toSet()

    override fun solve(): Any {
        var best = primeList.asSequence().scan(0L) { acc, p -> acc + p }.filter{it < primeList.last()}.withIndex().last{ it.value.toInt() in primeSet }
        println("0 $best")
        var i = 1
        while (i + best.index < primeList.size) {
            val x = primeList.asSequence().drop(i).scan(0L) { acc, p -> acc + p }.filter{it < primeList.last()}.withIndex().last{ it.value.toInt() in primeSet }
            if (x.index > best.index) {
                best = x
                println("$i $best")
            }
            i++
        }
        return best
    }

}