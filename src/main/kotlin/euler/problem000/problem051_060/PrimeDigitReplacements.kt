package euler.problem000.problem051_060

import euler.EulerExecutable
import tool.math.getPrimeList

class PrimeDigitReplacements: EulerExecutable {

    private val primeList = getPrimeList(1_000_000)
    private val primeSet = primeList.toSet()

    override fun solve(): Any {
        return primeList.asSequence()
            .map{it.createPatterns()}.flatten().distinct()
            .map{it.patternToNumbers()}.first { numberList -> numberList.size == 8 }
            .first()
    }

    private fun Int.createPatterns(pattern: String=""): List<String> {
        return if (this == 0) {
            listOf(pattern)
        } else {
            listOf((this%10), '*').map { (this/10).createPatterns( it.toString() + pattern) }.flatten()
        }
    }

    private fun String.patternToNumbers(): List<Int> {
        return if (this.all{it == '*'} || this.none{it == '*'} )
            emptyList()
        else
            (if (this.startsWith('*')) ('1'..'9')  else  ('0'..'9'))
                .map{this.replace('*', it).toInt()}
                .filter{it in primeSet}
    }

}