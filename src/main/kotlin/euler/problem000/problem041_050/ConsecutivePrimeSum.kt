package euler.problem000.problem041_050

import euler.EulerExecutable
import tool.math.getPrimeList

class ConsecutivePrimeSum: EulerExecutable {

    private val primeList = getPrimeList(1_000_000)
    private val primeSet = primeList.map{it}.toSet()

    override fun solve(): Any {
        return solve3()
    }


    //
    // idea: start with a serie of all primes, that sums up to at least more than 1_000_000
    //       this will be the max length of the optimal serie.
    // then every iteration, lower the serie length.
    //     in the internal iteration, keep the serie length, but substract the firts one and add 'at the end'
    //     the next one of the primeList, until the sum is too big again, or until we find a sum that is prime
    //
    private fun solve3(): Any {
        for (maxSerieLength in 1000 downTo 0) {
            var i = 0
            var primeSum = primeList.take(maxSerieLength).sum()
            while (primeSum < 1_000_000) {
                if (primeSum in primeSet) {
                    return primeSum
                }
                primeSum = primeList.subList(i, maxSerieLength+i).sum()
                i++
            }
        }
        return "not found"
    }

    //
    // without list functions.
    //
    private fun solve2(): Any {
        var maxSerieLength = 0
        var startSum = 0
        while (startSum < 1_000_000) {
            startSum += primeList[maxSerieLength++]
        }
        maxSerieLength--

        while (maxSerieLength >= 0) {
            startSum -= primeList[maxSerieLength]
            var primeSum = startSum
            var i = 0
            while (i < primeList.size-maxSerieLength && primeSum < 1_000_000) {
                if (primeSum in primeSet) {
                    println(maxSerieLength-i)
                    return primeSum
                }
                primeSum = primeSum - primeList[i] + primeList[maxSerieLength+i]
                i++
            }
            maxSerieLength--
        }
        return "not found"
    }

    fun solve0(): Any {
        var best = primeList.asSequence().scan(0) { acc, p -> acc + p }.filter{it <= primeList.last()}.withIndex().last{ it.value in primeSet }
        println("0 $best")
        var i = 1
        while (i + best.index < primeList.size) {
            val x = primeList.asSequence().drop(i).scan(0) { acc, p -> acc + p }.filter{it <= primeList.last()}.withIndex().last{ it.value in primeSet }
            if (x.index > best.index) {
                best = x
                println("$i $best")
            }
            i++
        }
        return best
    }



//    0 IndexedValue(index=536, value=958577)
//    2 IndexedValue(index=539, value=978037)
//    3 IndexedValue(index=543, value=997651)


}