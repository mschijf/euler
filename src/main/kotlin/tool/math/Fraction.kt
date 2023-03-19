package com.tool.math

import kotlin.math.absoluteValue
import kotlin.math.sign

class Fraction(numerator: Int, denumerator: Int) : Comparable<Fraction> {

    val normalizedNumerator: Int
    val normalizedDenominator: Int
    init {
        val gcd = gcd(numerator.absoluteValue, denumerator.absoluteValue)
        if (denumerator == 0) {
            normalizedNumerator = if (numerator == 0) 0 else numerator.sign
            normalizedDenominator = 0
        } else if (numerator == 0) {
            normalizedNumerator = 0
            normalizedDenominator = denumerator.sign
        } else {
            normalizedNumerator = numerator / gcd
            normalizedDenominator = denumerator / gcd
        }
    }

    private fun doubleValue() = normalizedNumerator.toDouble() /normalizedDenominator.toDouble()

    override fun compareTo(other: Fraction): Int {
        if (this == other)
            return 0

        if (normalizedDenominator == 0) {
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
            normalizedNumerator == other.normalizedNumerator && normalizedDenominator == other.normalizedDenominator
        } else {
            super.equals(other)
        }
    }
    override fun hashCode() = Pair(normalizedNumerator, normalizedDenominator).hashCode()
    override fun toString() = "($normalizedNumerator / $normalizedDenominator)"

    fun asDecimalString(): String {
        var decimalFraction = ""
        val remainderList = mutableListOf<Int>()

        var remainder = (normalizedNumerator % normalizedDenominator) * 10
        remainderList.add(remainder)
        while (remainder != 0 && remainder < normalizedDenominator) {
            remainder *= 10
            remainderList.add(remainder)
            decimalFraction += "0"
        }

        while (remainder != 0) {
            decimalFraction += remainder / normalizedDenominator

            remainder = (remainder % normalizedDenominator) * 10
            if (remainder == 0 || remainder in remainderList)
                break
            remainderList.add(remainder)
            while (remainder < normalizedDenominator) {
                remainder *= 10
                remainderList.add(remainder)
                decimalFraction += "0"
            }
        }

        val cycleLength = if (remainder != 0 && remainder in remainderList) remainderList.size - remainderList.indexOf(remainder) else 0
        val fixedFractionPart = decimalFraction.take(decimalFraction.length - cycleLength)
        val reciprocalCycle = if (cycleLength > 0) "(" + decimalFraction.takeLast(cycleLength) + ")" else ""
        val beforeComma = normalizedNumerator / normalizedDenominator
        val comma = if (decimalFraction.isNotEmpty()) "." else ""
        return "$beforeComma$comma$fixedFractionPart$reciprocalCycle"
    }


    fun reciprocalCycleLength(): Int {
        var remainder = (normalizedNumerator % normalizedDenominator) * 10
        if (remainder == 0) {
            return 0
        }

        val remainderList = mutableListOf<Int>()
        remainderList.add(remainder)
        while (remainder != 0 && remainder < normalizedDenominator) {
            remainder *= 10
            remainderList.add(remainder)
        }

        while (remainder != 0) {
            remainder = (remainder % normalizedDenominator) * 10
            if (remainder == 0 || remainder in remainderList)
                break
            remainderList.add(remainder)
            while (remainder < normalizedDenominator) {
                remainder *= 10
                remainderList.add(remainder)
            }
        }

        return if (remainder != 0 && remainder in remainderList)
            remainderList.size - remainderList.indexOf(remainder)
        else
            0
    }
}
