package euler.problem000.problem021_030

import tool.math.Fraction
import euler.EulerExecutable

class ReciprocalCycles: EulerExecutable {

    override fun solve(): Any {
//    println("983: ${Fraction(1,983).asDecimalString()}")
//    (1 until 20).forEach {println("$it: ${Fraction(1,it).asDecimalString()}") }
        return (1 until 1000).maxBy { Fraction(1, it).reciprocalCycleLength() }
    }
}

