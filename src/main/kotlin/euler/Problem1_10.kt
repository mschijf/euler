package euler

import com.tool.math.lcm
import kotlin.math.absoluteValue
import kotlin.math.max

fun main() {
    println("problem 1: ${multiplesOf3And5()}")
    println("problem 2: ${evenFibonacciNumbers()}")
    println("problem 3: ${largestPrimeFactor()}")
    println("problem 4: ${largestPalindromeProduct()}")
    println("problem 5: ${smallestMultiple()}")
    println("problem 6: ${sumSquareDifference()}")
    println("problem 7: ${eratosthenes()}")
}

fun multiplesOf3And5():Any {
    return (0 .. 999).filter {it % 3 == 0 || it % 5 == 0}.sum()
}

fun evenFibonacciNumbers(): Any {
    var x1 = 1
    var x2 = 1
    var sum = 0
    do {
        val x3 = (x2 + x1)
        x1 = x2
        x2 = x3
        sum += if (x3 % 2 == 0) x3 else 0
    } while (x3 < 4_000_000)
    return sum
}

fun largestPrimeFactor(): Any {
    var number = 600851475143
    var divider = 2
    while ( number >= divider ) {
        if (number % divider == 0L) {
            number /= divider
        } else {
            divider++
        }
    }
    return divider
}

fun largestPalindromeProduct(): Any {
    var max = 0
    for (first in 999 downTo 100) {
        if (first*999 < max)
            break
        for (second in 999 downTo 100) {
            val product = first * second
            if (product < max)
                break
            val s = product.toString()
            if (s == s.reversed())
                max = max(max, product)
        }
    }
    return max
}

fun smallestMultiple(): Any {
    var number = 1
    for (i in 2 .. 20) {
        number = lcm(number, i)
    }
    return number
}

fun sumSquareDifference(): Any {
    val n = 100
//    val tmp = (1..n).sum()
    val tmp = n * (n+1) / 2  //sum(1+2+3...+n) = (n(n+1)/2
    val squareOfSum = tmp * tmp
//    val sumOfSquare = (1..n).sumOf { it * it }
    val sumOfSquare = (2*n*n*n+3*n*n+n)/6  //sum(1^2+2^2+3^2...+n^2) = (2n^3 + 3n2 + n)/6
    return (sumOfSquare - squareOfSum).absoluteValue
}

fun eratosthenes(): Any {
    val n = 1000_000
    val strainer = Array(n){true}

    var count=0
    var i = 1
    while (i < n) {
        i++
        while (i < n && !strainer[i])
            i++
        count++
        if (count == 10_001)
            return i
        for (j in 2 * i until n step i)
            strainer[j] = false
    }
    return -1


}