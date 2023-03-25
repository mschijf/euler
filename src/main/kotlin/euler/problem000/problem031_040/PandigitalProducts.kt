package euler.problem000.problem031_040

import euler.EulerExecutable

class PandigitalProducts: EulerExecutable {

    override fun solve(): Any {
        val aaa = (1..98)
            .asSequence()
            .map { a-> (a+1..9876)
                .filter {b -> isPandigitalProductOf(a, b)}.map {b -> a*b} }
            .flatten()
            .toSet()
            .sum()
        return aaa
    }

    private fun isPandigitalProductOf(a: Int, b:Int): Boolean {
        val s=(a*b).toString() + a.toString() + b.toString()
        if (s.length != 9)
            return false

        return !s.withIndex().any{ch -> ch.value == '0' || s.indexOf(ch.value, ch.index+1) >= 0}
    }
}