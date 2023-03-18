package euler.problem000.problem011_020

fun latticePaths(): Any {
    val size = 20
    val grid = Array(size+1){ Array(size+1){ 1L } }

    for (row in 1 .. size) {
        for (col in 1 .. size) {
            grid[row][col] = grid[row-1][col] + grid[row][col-1]
        }
    }
    return grid[size][size]
}


// or calculate (40 over 20) = 40!/20!/20! = 40x39x...x21 / 20! = (39x37x35x..x21 x 2^10 ) / 10!
//
//   40 x 39 x 38 x ... x 22 x 21
//   20        19         11      x 10!

fun latticePathsByFac(): Any {
    val x = (21L..39 step 2).reduce{acc, i ->  acc*i}
    val y = 1L shl 10
    return (x * y) / 10L.fac()
}

private fun Long.fac():Long {
    return (1..this).reduce { acc, i ->  acc*i}
}
