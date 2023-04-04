package euler.problem000.problem051_060

import euler.EulerExecutable
import euler.getInputLinesFromFile
import tool.math.getPrimeList
import tool.math.isPrime

class PrimePairSets: EulerExecutable {

    private val primeList = getPrimeList(10_000)

    override fun solve(): Any {
        val set2 = mutableListOf<Set<Int>>()
        for (i1 in 0 until primeList.size-1) {
            for (i2 in i1+1 until primeList.size) {
                if (primeList[i1].primePairSet(primeList[i2])) {
                    set2.add(setOf(primeList[i1],primeList[i2]))
                }
            }
        }
        println(set2.size)

        val set5 = set2
            .extendOneMore()
            .extendOneMore()
            .extendOneMore()

        return set5.minBy{it.sum()}
    }

    private fun List<Set<Int>>.extendOneMore(): List<Set<Int>> {
        val result = mutableListOf<Set<Int>>()
        for (p in primeList) {
            for (s in this) {
                if (p.primePairSet(s)) {
                    result.add(s+p)
                }
            }
        }
        println(result.size)
        return result
    }

    private fun Int.primePairSet(aSet: Set<Int>): Boolean {
        if (this in aSet)
            return false
        return aSet.all{ this.primePairSet(it) }
    }

    private fun Int.primePairSet(other: Int): Boolean {
        if (this == other)
            return false
        val s1 = this.toString()
        val s2 = other.toString()
        if (s1.length + s2.length >= 9)
            return false
        val a = (s1+s2).toInt()
        val b = (s2+s1).toInt()
        val x = a.isPrime() && b.isPrime()
        return x
    }

}

//
//18176
//29712
//3528
//60