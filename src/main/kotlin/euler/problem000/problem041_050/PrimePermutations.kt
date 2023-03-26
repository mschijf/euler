package euler.problem000.problem041_050

import euler.EulerExecutable
import tool.math.getPrimeList

class PrimePermutations: EulerExecutable {

    override fun solve(): Any {
        val primeSet = getPrimeList(10_000)
            .filter { it > 1000 }
            .map{Pair(it, it.allDigits())}
            .groupBy(keySelector = { it.second }, valueTransform = {it.first} )
            .filterValues { it.size >= 3 }

        return primeSet.values
            .map{it.sorted().getThreeSequence()}
            .filter { it.isNotEmpty() }
            .map { it.joinToString("")}
            .filter { it != "148748178147" }
            .first()
    }

    private fun Int.allDigits(): Set<Int> {
        var result = mutableSetOf<Int>()
        var base = this
        while (base != 0) {
            result.add(base % 10)
            base /= 10
        }
        return result
    }

    private fun List<Int>.getThreeSequence(): List<Int> {
        this.forEach {first ->
            this.filter{it > first}.forEach { second ->
                this.filter{it > second}.forEach { third ->
                    if (third - second == second - first)
                        return listOf(first, second, third)
                }
            }
        }
        return emptyList()
    }

}