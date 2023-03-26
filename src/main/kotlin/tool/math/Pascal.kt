package tool.math

import kotlin.math.sqrt

// t = n(n+1)/2  ==> 0 = 0.5n^2 + 0.5n - t ==> (abc formula) ==> (-0.5 + sqrt(0.25 + 2h)) / 1 = (-1 + sqrt(1 + 8h))/2
fun Long.isTriangular(): Boolean {
    val i = ((sqrt(1.0 + 8*this) - 1) / 2)
    return (i % 1) == 0.0
}

// p = n(3n-1)/2 ==> 0 = 1.5n^2 -0.5n - p ==> (abc formula) ==> ... (1 + sqrt(1 + 24p)) / 6
fun Long.isPentagonal(): Boolean {
    val i = ((1 + sqrt(1.0 + 24*this)) / 6)
    return (i % 1) == 0.0
}

// h = n(2n-1)  ==> 0 = 2n^2 - n - h ==> (abc formula) ==> (1 + sqrt(1 + 8h)) / 4
fun Long.isHexagonal(): Boolean {
    val i = ((1 + sqrt(1.0 + 8*this)) / 4)
    return (i % 1) == 0.0
}

fun Int.isTriangular() = this.toLong().isTriangular()
fun Int.isPentagonal() = this.toLong().isPentagonal()
fun Int.isHexagonal() = this.toLong().isHexagonal()
