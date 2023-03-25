package euler.problem000.problem021_030

import euler.EulerExecutable

class DistinctPowers: EulerExecutable {
    override fun solve(): Any {
        return (2..100)
            .map{a -> a.toBasePower()}
            .map{bfp-> (2..100).map{ b-> Pair(bfp.base, b*bfp.power)}}
            .flatten()
            .toSet()
            .count()
    }

    private fun Int.toBasePower(): BasePower {
        return when(this) {
            4 ->BasePower(2,2)
            8 ->BasePower(2,3)
            16->BasePower(2,4)
            32->BasePower(2,5)
            64->BasePower(2,6)
             9->BasePower(3,2)
            27->BasePower(3,3)
            81->BasePower(3,4)
            25->BasePower(5,2)
            36->BasePower(6,2)
            49->BasePower(7,2)
            100->BasePower(10,2)
            else -> BasePower(this, 1)
        }
    }
}

data class BasePower(val base: Int, val power: Int)