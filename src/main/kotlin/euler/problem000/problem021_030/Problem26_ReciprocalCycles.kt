package euler.problem000.problem021_030

fun reciprocalCycles(): Any {
    (1 until 20).forEach { println("$it: ${asDecimal(1, it)}")}
    return (1 until 1000).maxBy { asDecimal(1, it).second }
}


private fun asDecimal(numerator: Int, denominator: Int): Pair<String, Int> {
    val remainderList = mutableListOf<Int>()
    var decimalFraction = ""

    var remainder = (numerator % denominator) * 10
    if (remainder == 0 || remainder in remainderList)
        return Pair("${numerator / denominator}", 0)

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
    return Pair("$beforeComma.$fixedFractionPart$reciprocalCycle", cycleLength)
}

