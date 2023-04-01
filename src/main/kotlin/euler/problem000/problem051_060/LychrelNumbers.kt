package euler.problem000.problem051_060

import euler.EulerExecutable
import java.math.BigInteger

class LychrelNumbers: EulerExecutable {

    override fun solve(): Any {
        return (1..9999).count {it.isLychrelNumber(100)}
    }

    private fun Int.isLychrelNumber(maxIterations: Int = 50): Boolean {
        var iterationCount = 1
        var sum = BigInteger.valueOf(this.toLong()) + BigInteger.valueOf(this.toLong().toString().reversed().toLong())
        while (sum.toString() != sum.toString().reversed() && iterationCount < maxIterations) {
            val base = sum
            sum = base + base.toString().reversed().toBigInteger()
            iterationCount++
        }
        return (sum.toString() != sum.toString().reversed())
    }


}