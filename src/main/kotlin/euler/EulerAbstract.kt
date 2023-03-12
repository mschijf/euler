package euler

abstract class EulerAbstract {
    abstract fun solve(): Any

    fun printResult() {
        println("result: ${solve()}")
    }
}