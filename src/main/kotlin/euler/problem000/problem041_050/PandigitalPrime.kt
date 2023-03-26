package euler.problem000.problem041_050

import euler.EulerExecutable
import tool.math.isPrime
import tool.math.makeAllPermutations

class PandigitalPrime: EulerExecutable {

    override fun solve(): Any {
        val pandigitalPrimeList = (2..9)
            .map { makeAllPermutations((1..it).toList())
                .map{perm -> perm.joinToString("").toInt()}.filter{ it.isPrime() } }
            .flatten()
        return pandigitalPrimeList.max()
    }
}