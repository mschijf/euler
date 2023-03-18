package euler.problem000.problem011_020

import euler.getInputLinesFromFile

fun largeSumUsingBigDecimal(): Any {
    return getInputLinesFromFile("data/input013")
        .map{it.toBigDecimal()}
        .sumOf {bd -> bd}
        .toString()
        .take(10)
}

// use only first 11 digits, and sum those
fun largeSum(): Any {
    return getInputLinesFromFile("data/input013")
        .sumOf { it.take(11).toLong() }
        .toString()
        .take(10)
}
