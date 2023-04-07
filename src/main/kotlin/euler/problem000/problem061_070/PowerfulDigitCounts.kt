package euler.problem000.problem061_070

import euler.EulerExecutable
import euler.problem000.problem011_020.powerDigitSum
import tool.math.*
import java.math.BigInteger

class PowerfulDigitCounts: EulerExecutable {

    override fun solve(): Any {
        var count = 0

        for (i in 1..9) {
            val base = BigInteger.valueOf(i.toLong())
            var power = 1

            var number = base.pow(power)
            var digitLength = number.toString().length
            while (power <= digitLength) {
                if (power == digitLength)
                    count++
                power++
                number = base.pow(power)
                digitLength = number.toString().length
            }
        }

        return count

    }
}

