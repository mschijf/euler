package euler.problem000.problem011_020

import euler.getInputLinesFromFile
import tool.position.Coordinate
import tool.position.WindDirection
import kotlin.math.max

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