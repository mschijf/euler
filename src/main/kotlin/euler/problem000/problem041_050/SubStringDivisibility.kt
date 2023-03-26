package euler.problem000.problem041_050

import euler.EulerExecutable
import tool.math.isPrime
import tool.math.makeAllPermutations

class SubStringDivisibility: EulerExecutable {

    override fun solve(): Any {
        return makeAllPermutations(listOf(0,1,2,3,4,5,6,7,8,9))
            .filter { perm -> perm.first() != 0 }
            .map{perm -> perm.fold(0L) {acc, i -> 10*acc + i}}
            .filter{pandigitalNumber -> pandigitalNumber.isSubstringDivisble()}
            .sum()
    }

    private fun Long.isSubstringDivisble(): Boolean {
        return  (this / 1_000_000 % 1000) % 2 == 0L &&
                (this / 100_000 % 1000) % 3 == 0L &&
                (this / 10_000 % 1000) % 5 == 0L &&
                (this / 1_000 % 1000) % 7 == 0L &&
                (this / 100 % 1000) % 11 == 0L &&
                (this / 10 % 1000) % 13 == 0L &&
                (this / 1 % 1000) % 17 == 0L
    }
}