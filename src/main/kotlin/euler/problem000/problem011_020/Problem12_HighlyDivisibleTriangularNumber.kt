package euler.problem000.problem011_020

import tool.math.dividerCount

fun highlyDivisibleTriangularNumber():Any {
    var n=1
    var triangleN = 1
    do {
        n++
        triangleN += n
    } while (triangleN.dividerCount() < 500)
    return triangleN
}

