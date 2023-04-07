package euler.problem000.problem061_070

import euler.EulerExecutable
import tool.math.*

class CubicPermutations: EulerExecutable {

    override fun solve(): Any {
        val qubics = (1..1_000_0L).map{it*it*it}
        return qubics
            .groupBy{it.toDigitList().sorted().toLong()}
            .filter{it.value.size == 5}
            .map{ it.value.min() }
            .min()
    }

    fun List<Int>.toLong() : Long {
        var acc = 0L
        for (i in this.size-1 downTo 0) {
            acc = 10*acc + this[i]
        }
        return acc
    }


}

