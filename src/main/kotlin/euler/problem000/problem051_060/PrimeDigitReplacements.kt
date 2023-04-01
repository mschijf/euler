package euler.problem000.problem051_060

import euler.EulerExecutable
import tool.math.getPrimeList

class PrimeDigitReplacements: EulerExecutable {

    private val primeList = getPrimeList(1_000_000)
    private val primeSet = primeList.toSet()

    override fun solve(): Any {
        return primeList.map{it.createPatterns()}.filter{it.size == 8}.distinct()
    }

    private fun Int.createPatterns(pattern: String=""): List<Int> {
        return if (this == 0) {
            pattern.checkPattern()
        } else {
            listOf((this%10), '*')
                .map { (this/10).createPatterns( it.toString() + pattern) }
                .maxBy { it.size }
        }
    }

    private fun String.checkPattern(): List<Int> {
        if (this.all{it == '*'} || this.none{it == '*'} )
            return emptyList()
        return (if (this.startsWith('*')) ('1'..'9')  else  ('0'..'9'))
            .map{this.replace('*', it).toInt()}
            .filter{it in primeSet}
    }

}