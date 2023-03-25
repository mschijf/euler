package euler.problem000.problem021_030

import euler.EulerExecutable
import tool.math.sumOfProperDivisors

class NonAbundantSums: EulerExecutable {

    override fun solve(): Any {
        val abundantNumbers = (1..28123).filter { it.isAbundant() }
        val allSums = abundantNumbers.map { ab1 -> abundantNumbers.map { ab2 -> ab1 + ab2 } }
            .flatten()
            .toSet()
        return (1..28123).filterNot { allSums.contains(it) }.sum()
    }

    private fun Int.isAbundant() = this.sumOfProperDivisors() > this
}


//answer = 4179871