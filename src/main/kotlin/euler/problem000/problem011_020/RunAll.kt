package euler.problem000.problem011_020

fun main() {
    execute(11) { largestProductInGrid() }
    execute(12) { highlyDivisibleTriangularNumber() }
    execute(13) { largeSum() }
    execute(14) { longestCollatzSequence() }
    execute(15) { latticePaths() }
    execute(16) { powerDigitSum() }
    execute(17) { numberLetterCounts() }
    execute(18) { maximumPathSum1() }
    execute(19) { countingSundays() }
    execute(20) { factorialDigitSum() }
}

private fun execute(problemNumber: Int?=null, problemName: String? = null, getResult: () -> Any) {
    val startTime = System.currentTimeMillis()
    val result = getResult()
    val timePassed = System.currentTimeMillis() - startTime

    print("Result")
    if (problemNumber != null) print(java.lang.String.format(" of problem %3d", problemNumber))
    if (problemName != null) print(java.lang.String.format(" - %-30s", problemName))
    print(java.lang.String.format(": %20s", result))
    println(java.lang.String.format(" (after %d.%03d sec)", timePassed / 1000, timePassed % 1000))
}

