package euler

import com.tool.math.lcm
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

fun execute(problemNumber: Int, getResult: () -> Any) {
    val startTime = System.currentTimeMillis()
    val result = getResult()
    val timePassed = System.currentTimeMillis() - startTime
    println("Result of problem $problemNumber: $result (after ${timePassed / 1000}.${timePassed % 1000} sec)")
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
//    val n = 1_000_000
//    val strainer = Array(n){true}
//
//    var count=0
//    var i = 1
//    while (i < n) {
//        i++
//        while (i < n && !strainer[i])
//            i++
//        count++
//        if (count == 10_001)
//            return i
//        for (j in 2 * i until n step i)
//            strainer[j] = false
//    }
//    return -1
    return getPrimeList(200_000)[10_001-1] //0-based
}

fun largestProductInASeries(): Any {
    val input =
        "73167176531330624919225119674426574742355349194934" +
        "96983520312774506326239578318016984801869478851843" +
        "85861560789112949495459501737958331952853208805511" +
        "12540698747158523863050715693290963295227443043557" +
        "66896648950445244523161731856403098711121722383113" +
        "62229893423380308135336276614282806444486645238749" +
        "30358907296290491560440772390713810515859307960866" +
        "70172427121883998797908792274921901699720888093776" +
        "65727333001053367881220235421809751254540594752243" +
        "52584907711670556013604839586446706324415722155397" +
        "53697817977846174064955149290862569321978468622482" +
        "83972241375657056057490261407972968652414535100474" +
        "82166370484403199890008895243450658541227588666881" +
        "16427171479924442928230863465674813919123162824586" +
        "17866458359124566529476545682848912883142607690042" +
        "24219022671055626321111109370544217506941658960408" +
        "07198403850962455444362981230987879927244284909188" +
        "84580156166097919133875499200524063689912560717606" +
        "05886116467109405077541002256983155200055935729725" +
        "71636269561882670428252483600823257530420752963450"

    val numberList = input.map { it.digitToInt().toLong() }
    val adjacentDigits = 13
    return numberList
        .windowed(adjacentDigits)
        .maxOf{list -> list.reduce { acc, i -> acc*i }}
}

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

fun summationOfPrimes(): Any {
    return getPrimeList(2_000_000).sumOf { it.toLong() }
}
