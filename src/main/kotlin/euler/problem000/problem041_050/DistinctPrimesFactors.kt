package euler.problem000.problem041_050

import euler.EulerExecutable
import tool.math.getPrimeList
import tool.math.primeDividers

class DistinctPrimesFactors: EulerExecutable {

    private val max= 10_000_000
    override fun solve(): Any {
        return (2*3*4*5..max)
            .asSequence()
            .filter{it.primeDividers().count() == 4}
            .windowed(4)
            .filter{it[0]+1 == it[1] && it[1]+1 == it[2] && it[2]+1 == it[3]}
            .first()
    }

}