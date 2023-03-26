package euler.problem000.problem041_050

import euler.EulerExecutable
import tool.math.isPentagonal

class TriangularPentagonalHexagonal: EulerExecutable {

//    override fun solve(): Any {
//        (285+1 .. 100_000L).forEach { i ->
//            val triangle = i*(i+1)/2
//            if (triangle.isHexagonal() && triangle.isPentagonal()) {
//                return "$triangle"
//            }
//        }
//        return "Not found"
//    }

    // every hexagonal is a triangular number.
    // Therefore, start generating the hexagonals and only chck if it is a pentagon.
    override fun solve(): Any {
        (285+1 .. 100_000L).forEach { i ->
            val hex = i*(2*i-1)
            if (hex.isPentagonal()) {
                return "$i $hex"
            }
        }
        return "Not found"
    }

}