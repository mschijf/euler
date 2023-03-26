package euler.problem000.problem041_050

import euler.EulerExecutable
import euler.getInputLinesFromFile

class CodedTriangleNumbers: EulerExecutable {

    override fun solve(): Any {
        val wordList = getInputLinesFromFile("data/input042").first().split(",").map{it.substring(1, it.length-1)}
        val wordValueList = wordList.map{word -> word.uppercase().sumOf{ch -> ch - 'A' + 1}}
        val triangleNumbers = createTriangleNumberSet(wordValueList.max()+1)
        return wordValueList.count{wordValue -> wordValue in triangleNumbers}
    }


    private fun createTriangleNumberSet(max: Int):Set<Int> {
        val result = mutableSetOf<Int>()
        var triangle = 1
        var i = 1
        while (triangle < max) {
            result.add(triangle)
            triangle += ++i
        }
        return result
    }

    fun triangle(max: Int): List<Int> {
        var i = 1
        var triangle = 1
        val sequence = generateSequence {
            (triangle).takeIf { it < max }.also { triangle += ++i }
        }
        return sequence.toList()
    }


    // to produce 100 triangleNumbers, you can do:
    //
    //(1..100).runningReduce { acc, i -> acc + i }
}