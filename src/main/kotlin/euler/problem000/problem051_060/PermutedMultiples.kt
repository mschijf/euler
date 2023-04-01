package euler.problem000.problem051_060

import euler.EulerExecutable
import tool.math.*

class PermutedMultiples: EulerExecutable {

    override fun solve(): Any {
        return (1..1_000_000)
            .filter{x -> x.isMultiplePermuted()}
    }

    private fun Int.isMultiplePermuted(): Boolean {
        val twoSet = (this*2).toDigitSet()
        return (3..6)
            .map{this*it}
            .map{it.toDigitSet()}
            .all{set -> set == twoSet}
    }

}