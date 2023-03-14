package euler

import com.tool.math.lcm
import tool.math.getPrimeList
import tool.position.Coordinate
import tool.position.Direction
import tool.position.WindDirection
import kotlin.math.absoluteValue
import kotlin.math.max
import kotlin.math.round
import kotlin.math.sqrt

fun main() {
    execute(11) { largestProductInGrid() }
    execute(12) { highlyDivisibleTriangularNumber() }
    execute(13) { largeSum() }
//    execute(14) { largestPalindromeProduct() }
//    execute(15) { smallestMultiple() }
//    execute(16) { sumSquareDifference() }
//    execute(17) { eratosthenes() }
//    execute(18) { largestProductInASeries() }
//    execute(19) { specialPythagoreanTriplet() }
//    execute(20) { summationOfPrimes() }
}


//11
fun largestProductInGrid(): Any {
    val numberMap =
        getInputLinesFromFile("data/input011")
            .map{line -> line.split(" ")}
            .flatMapIndexed { y, row -> row.mapIndexed { x, value -> Pair(Coordinate(x,y), value.toInt()) } }
            .toMap()

    var maxProduct = -1
    for (y in 0..19) {
        for (x in 0..19) {
            maxProduct = max(maxProduct, numberMap.productOfFourInLine(Coordinate(x,y), WindDirection.SOUTH))
            maxProduct = max(maxProduct, numberMap.productOfFourInLine(Coordinate(x,y), WindDirection.EAST))
            maxProduct = max(maxProduct, numberMap.productOfFourInLine(Coordinate(x,y), WindDirection.SOUTHWEST))
            maxProduct = max(maxProduct, numberMap.productOfFourInLine(Coordinate(x,y), WindDirection.SOUTHEAST))
        }
    }
    return maxProduct
}

private fun Map<Coordinate, Int>.productOfFourInLine(c: Coordinate, dir: WindDirection): Int {
    val x0 = this[c]?:0
    val x1 = this[c.moveOneStep(dir)]?:0
    val x2 = this[c.moveOneStep(dir).moveOneStep(dir)]?:0
    val x3 = this[c.moveOneStep(dir).moveOneStep(dir).moveOneStep(dir)]?:0
    return x0 * x1 * x2 * x3
}


//12
fun highlyDivisibleTriangularNumber():Any {
    var n=1
    var triangleN = 1
    do {
        n++
        triangleN += n
    } while (dividerCount(triangleN) < 500)
    return triangleN
}

private fun dividerCount(n: Int): Int {
    var count = 1
    for (i in 2 ..sqrt(n.toDouble()).toInt()) {
        if (n % i == 0)
            count++
    }
    return 2*count
}


//13
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
