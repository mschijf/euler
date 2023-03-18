package tool.math

import kotlin.math.sqrt

fun Int.properDivisors(): Set<Int> {
    val resultSet = mutableSetOf(1)
    for (i in 2 ..sqrt(this.toDouble()).toInt()) {
        if (this % i == 0) {
            resultSet.add(i)
            resultSet.add(this / i)
        }
    }
    return resultSet
}

fun Int.dividerCount(): Int {
    var count = 1
    for (i in 2 ..sqrt(this.toDouble()).toInt()) {
        if (this % i == 0)
            count++
    }
    return 2*count
//    return properDivisors().count()+1
}

fun Int.sumOfProperDivisors(): Int {
    var sum = 1
    for (i in 2 ..sqrt(this.toDouble()).toInt()) {
        if (this % i == 0)
            sum += (i + this / i)
    }
    return sum
//    return properDivisors().sum()
}
