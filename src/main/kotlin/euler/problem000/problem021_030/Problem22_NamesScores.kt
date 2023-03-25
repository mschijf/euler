package euler.problem000.problem021_030

import euler.EulerExecutable
import euler.getInputLinesFromFile

class NamesScores: EulerExecutable {

    override fun solve(): Any {
        return getInputLinesFromFile("data/input022")
            .first()
            .split(",")
            .map { it.substring(1, it.length - 1) }
            .sorted()
            .withIndex()
            .sumOf { (it.index + 1) * nameSum(it.value) }
    }

    private fun nameSum(name: String) = name.sumOf { ch -> ch - 'A' + 1 }
}


//871198282
