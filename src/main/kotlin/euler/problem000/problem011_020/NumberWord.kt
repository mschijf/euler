package euler.problem000.problem011_020

class NumberWord {
    val map = mapOf(1 to "one", 2 to "two", 3 to "three", 4 to "four", 5 to "five",
        6 to "six", 7 to "seven", 8 to "eight", 9 to "nine", 10 to "ten",
        11 to "eleven", 12 to "twelve", 13 to "thirteen", 14 to "fourteen", 15 to "fifteen",
        16 to "sixteen", 17 to "seventeen", 18 to "eighteen", 19 to "nineteen",
        20 to "twenty", 30 to "thirty", 40 to "forty", 50 to "fifty",
        60 to "sixty", 70 to "seventy", 80 to "eighty", 90 to "ninety",
        100 to "hundred",
        1000 to "thousand")

    fun toWord(number: Int): String {
        if (number == 0)
            return ""
        if (number < 20)
            return (map[number]!!)
        if (number < 100)
            return (map[10 * (number / 10)]!! + if (number % 10 == 0) "" else "-" + toWord(number % 10))
        if (number < 1000)
            return map[number/100] + " " + map[100] + if (number % 100 == 0) "" else " and " + toWord(number % 100)
        return map[number/1000] + " " + map[1000] + if (number % 1000 == 0) "" else " and " + toWord(number % 100)
    }

}