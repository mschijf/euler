package euler.problem000.problem041_050

import euler.EulerExecutable

class SelfPowers: EulerExecutable {

    override fun solve(): Any {
        return (1..1000L).sumOf { it.powerModulo(it.toInt(), 10_000_000_000) } % 10_000_000_000
    }

    private fun Long.powerModulo(power: Int, modulo: Long): Long {
        var result = 1L
        repeat(power) {
            result = result*this % modulo
        }
        return result
    }
}