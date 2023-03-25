package euler

import java.io.File
import java.lang.String.format
import kotlin.reflect.KClass

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

fun execute(eulerExecutableClass: KClass<out EulerExecutable>) {
    val startTime = System.currentTimeMillis()

    val eulerExecutable = eulerExecutableClass.java.getDeclaredConstructor().newInstance()

    val problemName =  eulerExecutableClass.simpleName
    val problemNumber = eulerExecutable.problemNumber
    val result = eulerExecutable.solve()

    val timePassed = System.currentTimeMillis() - startTime

    print("Result")
    if (problemNumber != null) print(format(" of problem %3d", problemNumber))
    if (problemName != null) print(format(" - %-30s", problemName))
    print(format(": %20s", result) )
    println(format(" (after %d.%03d sec)", timePassed / 1000, timePassed % 1000))
}

fun getInputLinesFromFile(fileName: String): List<String> {
    val file = File(fileName)
    return if (file.exists()) file.bufferedReader().readLines() else emptyList()
}