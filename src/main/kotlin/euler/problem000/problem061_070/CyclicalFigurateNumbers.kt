package euler.problem000.problem061_070

import euler.EulerExecutable
import tool.math.*

class CyclicalFigurateNumbers: EulerExecutable {

    private val allSet = (3..8).map{ poly->(1..1000).map{ getPolygonal(poly, it) }.filter{it in 1000..9999}}
    private val cycleMap = allSet.flatten().toSet().groupBy { it/100 }

    override fun solve(): Any {
//        findSequence().forEach{ println(it) }
        return findSequence().first().sum()
    }

    private fun findSequence(length: Int = 6, polyNeeded: Set<Int> = setOf(3,4,5,6,7,8), sequenceDone: List<Int> = emptyList()): Set<List<Int>> {
        if (length == 0) {
            return if (sequenceDone.last() % 100 == sequenceDone.first() / 100) {
                setOf(sequenceDone)
            } else {
                emptySet()
            }
        } else {
            val result = mutableSetOf<List<Int>>()
            val nextNumbers = generatePairs(sequenceDone, polyNeeded)
            nextNumbers.forEach {
                result += findSequence(length-1, polyNeeded - it.first, sequenceDone + it.second)
            }
            return result
        }
    }

    private fun generatePairs(sequenceDone: List<Int>, polyNeeded: Set<Int>): List<Pair<Int, Int>> {
        if (sequenceDone.isEmpty()) {
            return allSet[8 - 3].map { octa -> Pair(8, octa) }
        } else {
            val base = cycleMap[sequenceDone.last() % 100]?.filter { it !in sequenceDone } ?: emptyList()
            return base.map { nr ->
                polyNeeded.filter { poly -> nr.isPolygonal(poly) }.map { poly -> Pair(poly, nr) }
            }.flatten()
        }
    }

}




// method 2
//        val allSet = (3..8).map{poly->(1..1000).map{ getPolygonal(poly, it) }.filter{it in 1000..9999}}
//        allSet.forEach { polySet ->
//            polySet.forEach { if (!cycleMap.contains(it/100)) cycleMap[it/100] = mutableSetOf(it) else cycleMap[it/100]!!.add(it)  }
//        }

// method 1
//        val cycleMap = mutableMapOf<Int, MutableSet<Int>>()
//        val octaSet =  (1..1000).map{ getOctagonal(it) }.filter{it in 1000..9999}
//        val heptaSet =  (1..1000).map{ getHeptagonal(it) }.filter{it in 1000..9999}
//        val hexaSet =  (1..1000).map{ getHexagonal(it) }.filter{it in 1000..9999}
//        val pentaSet =  (1..1000).map{ getPentagonal(it) }.filter{it in 1000..9999}
//        val squareSet =  (1..1000).map{ getSquare(it) }.filter{it in 1000..9999}
//        val triangleSet =  (1..1000).map{ getTriangle(it) }.filter{it in 1000..9999}
//
//        val cycleMap = mutableMapOf<Int, MutableSet<Int>>()
//        octaSet.forEach { if (!cycleMap.contains(it/100)) cycleMap[it/100] = mutableSetOf(it) else cycleMap[it/100]!!.add(it)  }
//        heptaSet.forEach { if (!cycleMap.contains(it/100)) cycleMap[it/100] = mutableSetOf(it) else cycleMap[it/100]!!.add(it)  }
//        hexaSet.forEach { if (!cycleMap.contains(it/100)) cycleMap[it/100] = mutableSetOf(it) else cycleMap[it/100]!!.add(it)  }
//        pentaSet.forEach { if (!cycleMap.contains(it/100)) cycleMap[it/100] = mutableSetOf(it) else cycleMap[it/100]!!.add(it)  }
//        squareSet.forEach { if (!cycleMap.contains(it/100)) cycleMap[it/100] = mutableSetOf(it) else cycleMap[it/100]!!.add(it)  }
//        triangleSet.forEach { if (!cycleMap.contains(it/100)) cycleMap[it/100] = mutableSetOf(it) else cycleMap[it/100]!!.add(it)  }

