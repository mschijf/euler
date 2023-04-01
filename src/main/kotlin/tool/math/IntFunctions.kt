package tool.math

fun Int.toDigitList(): List<Int> {
    val result = mutableListOf<Int>()
    var base = this
    while (base != 0) {
        result.add( base % 10)
        base /= 10
    }
    return result.reversed()
}

fun Int.toDigitSet(): Set<Int> {
    val result = mutableSetOf<Int>()
    var base = this
    while (base != 0) {
        result.add( base % 10)
        base /= 10
    }
    return result
}


fun Int.log10(): Int {
    var base = this
    var c = -1
    while (base > 0) {
        base /= 10
        c++
    }
    return c
}

fun Int.digitLength() = this.log10()+1
