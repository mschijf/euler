package euler

import java.io.File

fun execute(problemNumber: Int?=null, getResult: () -> Any) {
    val startTime = System.currentTimeMillis()
    val result = getResult()
    val timePassed = System.currentTimeMillis() - startTime
    println("Result ${if (problemNumber == null) "" else "of problem $problemNumber"}: $result (after ${timePassed / 1000}.${timePassed % 1000} sec)")
}

fun getInputLinesFromFile(fileName: String): List<String> {
    val file = File(fileName)
    return if (file.exists()) file.bufferedReader().readLines() else emptyList()
}