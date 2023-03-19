package com.tool.math

import kotlin.math.absoluteValue
import kotlin.math.sign

class Fraction(numerator: Int, denumerator: Int) : Comparable<Fraction> {

    val normalizedNumerator: Int
    val normalizedDenumerator: Int
    init {
        val gcd = gcd(numerator.absoluteValue, denumerator.absoluteValue)
        if (denumerator == 0) {
            normalizedNumerator = if (numerator == 0) 0 else numerator.sign
            normalizedDenumerator = 0
        } else if (numerator == 0) {
            normalizedNumerator = 0
            normalizedDenumerator = denumerator.sign
        } else {
            normalizedNumerator = numerator / gcd
            normalizedDenumerator = denumerator / gcd
        }
    }

    private fun doubleValue() = normalizedNumerator.toDouble() /normalizedDenumerator.toDouble()

    override fun compareTo(other: Fraction): Int {
        if (this == other)
            return 0

        if (normalizedDenumerator == 0) {
            return if (this.normalizedNumerator.sign == other.normalizedNumerator.sign)
                0
            else if (this.normalizedNumerator.sign < other.normalizedNumerator.sign)
                -1
            else
                1
        } else {
            return if (this.doubleValue() < other.doubleValue())
                -1
            else
                1
        }
    }

    override fun equals(other: Any?): Boolean {
        return if (other is Fraction) {
            normalizedNumerator == other.normalizedNumerator && normalizedDenumerator == other.normalizedDenumerator
        } else {
            super.equals(other)
        }
    }
    override fun hashCode() = Pair(normalizedNumerator, normalizedDenumerator).hashCode()
    override fun toString() = "($normalizedNumerator / $normalizedDenumerator)"

    fun asDecimalString(numerator: Int, denominator: Int): String {
        var remainder = (numerator % denominator) * 10
        if (remainder == 0) {
            return "${numerator / denominator}"
        }

        var decimalFraction = ""
        val remainderList = mutableListOf<Int>()
        remainderList.add(remainder)
        while (remainder != 0 && remainder < denominator) {
            remainder *= 10
            remainderList.add(remainder)
            decimalFraction += "0"
        }

        while (remainder != 0) {
            decimalFraction += remainder / denominator

            remainder = (remainder % denominator) * 10
            if (remainder == 0 || remainder in remainderList)
                break;
            remainderList.add(remainder)
            while (remainder < denominator) {
                remainder *= 10
                remainderList.add(remainder)
                decimalFraction += "0"
            }
        }

        val cycleLength = if (remainder != 0 && remainder in remainderList) remainderList.size - remainderList.indexOf(remainder) else 0
        val fixedFractionPart = decimalFraction.take(decimalFraction.length - cycleLength)
        val reciprocalCycle = if (cycleLength > 0) "(" + decimalFraction.takeLast(cycleLength) + ")" else ""
        val beforeComma = numerator / denominator
        return "$beforeComma.$fixedFractionPart$reciprocalCycle"
    }
}
