package euler

import java.io.File
import java.lang.String.format
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance

fun execute(problemNumber: Int, eulerExecutableClass: KClass<out EulerExecutable>) {
    val startTime = System.currentTimeMillis()

    val eulerExecutable = eulerExecutableClass.createInstance()

    val problemName =  eulerExecutableClass.simpleName
    val result = eulerExecutable.solve()

    val timePassed = System.currentTimeMillis() - startTime

    print("Result")
    print(format(" of problem %3d", problemNumber))
    print(format(" - %-30s", problemName))
    print(format(": %20s", result) )
    println(format(" (after %d.%03d sec)", timePassed / 1000, timePassed % 1000))
}

fun getInputLinesFromFile(fileName: String): List<String> {
    val file = File(fileName)
    return if (file.exists()) file.bufferedReader().readLines() else emptyList()
}