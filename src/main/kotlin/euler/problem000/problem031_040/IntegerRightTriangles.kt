package euler.problem000.problem031_040

import euler.EulerExecutable

class IntegerRightTriangles: EulerExecutable {
    override val problemNumber = 39

    override fun solve(): Any {
        return (1..1000).maxBy {p ->
            (1..p/3).sumOf { a ->
                    (a..(p-a)/2).count { b -> val c=(p-a-b); a*a + b*b == c*c } }}
    }

}