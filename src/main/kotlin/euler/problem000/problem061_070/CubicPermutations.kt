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
}

