package euler.problem000.problem011_020

import kotlin.math.sqrt

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
