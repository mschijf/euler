package euler.problem000.problem041_050

import euler.EulerExecutable
import tool.math.getPrimeList

class GoldbachsOtherConjecture: EulerExecutable {

    private val max = 100_000
    private val squareList = (1..max).map{2*it*it}
    private val primeList = getPrimeList(max).toSet()

    override fun solve(): Any {
        for (goldBachMistake in 9 .. max step 2) {
            if (goldBachMistake !in primeList && !goldBachMistake.isGoldbachConjecture())
                return goldBachMistake
        }
        return "not found within max"
    }

    private fun Int.isGoldbachConjecture(): Boolean {
        return squareList.asSequence().filter{it < this}.any{(this - it) in primeList}
    }

}