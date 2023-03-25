package euler.problem000.problem031_040

import euler.EulerExecutable
import tool.math.getPrimeList

class PandigitalMultiples: EulerExecutable {
    override val problemNumber = 38

    override fun solve(): Any {

        return (1..9999)
            .map{ nr ->
                (2..9)
                    .map{ max -> nr.concatenateProduct(1..max) }
                    .filter{it.isPandigital()}
            }
            .flatten()
            .maxOf { it.toInt() }
    }

    private fun Int.concatenateProduct(multiplierList: IntRange): String {
        return multiplierList.map{this*it}.joinToString("")
    }

    private fun String.isPandigital(): Boolean {
        return this.length == 9 &&
                this.withIndex().none{ch -> ch.value == '0' || this.indexOf(ch.value, ch.index+1) >= 0}
    }

}