package tool.math

fun Int.toDigitList(): List<Int> = this.toLong().toDigitList()
fun Long.toDigitList(): List<Int> {
    val result = mutableListOf<Int>()
    var base = this
    while (base != 0L) {
        result.add( (base % 10).toInt())
        base /= 10
    }
    return result
}

fun List<Int>.toLong() : Long {
    var acc = 0L
    for (i in this.size-1 downTo 0) {
        acc = 10*acc + this[i]
    }
    return acc
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

fun Int.pow(power: Int):Long {
    var base = 1L
    repeat(power) {
        base *= this
    }
    return base
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

fun Int.digitSum(): Int {
    var sum = 0
    var base = this
    while (base != 0) {
        sum += base % 10
        base /= 10
    }
    return sum
}

