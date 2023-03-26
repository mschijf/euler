package euler.problem000.problem041_050

import euler.EulerExecutable
import tool.math.isHexagonal
import tool.math.isPentagonal
import kotlin.math.min

class TriangularPentagonalHexagonal: EulerExecutable {

    override fun solve(): Any {
        (285+1 .. 100_000L).forEach { i ->
            val triangle = i*(i+1)/2
            if (triangle.isHexagonal() && triangle.isPentagonal()) {
                return "$triangle"
            }
        }
        return "Not found"
    }
}