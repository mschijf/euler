package euler.problem000.problem021_030

import euler.EulerExecutable

class NumberSpiralDiagonals: EulerExecutable {

    override fun problemNumber() = 28

    /*
     * Looking at the spiral, we can see that every new round gets four new corners.
     * We see that (starting at the right top, counter clockwise):
     *
     *  3x3:   9   7   5   3
     *  5x5:  25  21  17  13    = 5^2  +  5^2-(5-1)  +  5^2-2*(5-1)  +  5^2-3*(5-1)
     *  ...
     *  nxn:  n^2  +  n^2 - 1*(n-1)  +  n^2 - 2*(n-1)  +  n^2 - 3*(n-1)
     *     =  4*n^2  -  6*(n-1)
     *
     * we need to sum these nxn corners for n=3,5,7,...1001, or for i=1,2,3,...,500 and take 2*i+1
     * this leads to (for n = 500):
     *
     *     n                                       n
     *    SUM  { 4(2i+1)^2  - 6(2i+1 - 1)  }  =   SUM  { 16i^2  +  4i  +  4  }
     *    i=1                                     i=1
     *
     *           n               n             n
     *  =  16 * SUM i^2  +  4 * SUM i   + 4 * SUM 1
     *          i=1             i=1           i=1
     *
     *     16n(n+1)(2n+1)       4n(n+1)
     *  =  --------------  +    -------   +   4n
     *           6                 2
     *
     *  finally, when we execute this for n=500, we have the sum of all squares. For the sum of diagonals, we only need
     *  to add 1 (central position)
     */
    override fun solve(): Any {
        val n = 500L
        return (16*n*(n+1)*(2*n+1))/6 + (4*n*(n+1))/2 + 4*n + 1
    }
}