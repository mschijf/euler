package euler.problem000.problem011_020

import euler.getInputLinesFromFile
import kotlin.math.*

fun maximumPathSum1(): Any {
    val input = getInputLinesFromFile("data/input018")
        .map{line -> line.split(" ").map { nr -> nr.toInt() }.toIntArray()}

    val output = input
        .mapIndexed { row, line ->
            line.mapIndexed { col, value -> (value + input.maxUpper(row, col)).also{ input[row][col] = it } }
        }
    return output.last().max()
}

private fun List<IntArray>.maxUpper(row: Int, col: Int) : Int {
    return if (row <= 0)
        0
    else if (col == 0)
        this[row-1][col]
    else if (col == this[row-1].size)
        this[row-1][col-1]
    else
        max(this[row-1][col], this[row-1][col-1])
}
