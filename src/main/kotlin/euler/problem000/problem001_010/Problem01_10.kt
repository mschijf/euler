package euler.problem000.problem001_010

import com.tool.math.lcm
import euler.execute
import euler.getInputLinesFromFile
import tool.math.getPrimeList
import kotlin.math.absoluteValue
import kotlin.math.max

fun main() {
    execute(1) { multiplesOf3And5() }
    execute(2) { evenFibonacciNumbers() }
    execute(3) { largestPrimeFactor() }
    execute(4) { largestPalindromeProduct() }
    execute(5) { smallestMultiple() }
    execute(6) { sumSquareDifference() }
    execute(7) { eratosthenes() }
    execute(8) { largestProductInASeries() }
    execute(9) { specialPythagoreanTriplet() }
    execute(10) { summationOfPrimes() }
}

//1
fun multiplesOf3And5():Any {
    return (0 .. 999).filter {it % 3 == 0 || it % 5 == 0}.sum()
}

//2
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

//3
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

//4
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

//5
fun smallestMultiple(): Any {
    var number = 1
    for (i in 2 .. 20) {
        number = lcm(number, i)
    }
    return number
}

//6
fun sumSquareDifference(): Any {
    val n = 100
//    val tmp = (1..n).sum()
    val tmp = n * (n+1) / 2  //sum(1+2+3...+n) = (n(n+1)/2
    val squareOfSum = tmp * tmp
//    val sumOfSquare = (1..n).sumOf { it * it }
    val sumOfSquare = (2*n*n*n + 3*n*n + n)/6  //sum(1^2+2^2+3^2...+n^2) = (2n^3 + 3n2 + n)/6
    return (sumOfSquare - squareOfSum).absoluteValue
}

//7
fun eratosthenes(): Any {
    return getPrimeList(200_000)[10_001-1] //0-based
}

//8
fun largestProductInASeries(): Any {
//    val numberList = getInputLines("data/input008").map { line -> line.map{ ch -> ch.digitToInt().toLong()} }.flatten()
    val numberList = getInputLinesFromFile("data/input008").flatMap { line -> line.map{ ch -> ch.digitToInt().toLong()} }
    val adjacentDigits = 13
    return numberList
        .windowed(adjacentDigits)
        .maxOf{list -> list.reduce { acc, i -> acc*i }}
}


//9
fun specialPythagoreanTriplet(): Any {
    val n = 1000
    for (a in 1 .. n/3) {
        for (b in a+1 .. (n - a) / 2) {
            val c = n - a - b
            if (a*a + b*b == c*c)
                return a*b*c
        }
    }
    return 0
}

//10
fun summationOfPrimes(): Any {
    return getPrimeList(2_000_000).sumOf { it.toLong() }
}
