package euler.problem000.problem021_030

import euler.execute

fun main() {
    execute(21) { amicableNumbers() }
    execute(22) { namesScores() }
//    execute(23) { nonAbundantSums() }
    execute(24) { lexicographicPermutations() }
    execute(25) { indexOf1000DigitFibonacciNumber() }
    execute(26) { reciprocalCycles() }

    val eulerProjectList = listOf(
        QuadraticPrimes::class,
        NumberSpiralDiagonals::class,
        DistinctPowers::class,
        DigitFifthPowers::class,
    )
    eulerProjectList.forEachIndexed { index, kClass ->  execute(27+index, kClass) }
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


