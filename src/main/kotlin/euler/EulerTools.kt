package euler

import java.io.File
import java.lang.String.format

fun execute(problemNumber: Int?=null, problemName: String? = null, getResult: () -> Any) {
    val startTime = System.currentTimeMillis()
    val result = getResult()
    val timePassed = System.currentTimeMillis() - startTime

    print("Result")
    if (problemNumber != null) print(format(" of problem %3d", problemNumber))
    if (problemName != null) print(format(" - %-30s", problemName))
    print(format(": %20s", result) )
    println(format(" (after %d.%03d sec)", timePassed / 1000, timePassed % 1000))
}

fun execute(eulerExecutable: EulerExecutable) {
    val nr = eulerExecutable.problemNumber
    val name =  eulerExecutable.javaClass.name.substringAfterLast(".")
    execute(nr, name) { eulerExecutable.solve() }
}

fun getInputLinesFromFile(fileName: String): List<String> {
    val file = File(fileName)
    return if (file.exists()) file.bufferedReader().readLines() else emptyList()
}