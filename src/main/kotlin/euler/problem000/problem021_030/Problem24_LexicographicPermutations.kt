package euler.problem000.problem021_030

import euler.EulerExecutable
import tool.math.fac

class LexicographicPermutations: EulerExecutable {

    override fun solve(): Any {
        val permCountList = (0..9L).map { it.fac() }

        val result = mutableListOf<Int>()
        val list = mutableListOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        var findIndex = 999_999L
        for (i in 9 downTo 0) {
            val count = findIndex / permCountList[i]
            findIndex %= permCountList[i]
//        println("$i: $count  ($findIndex) $list --> ${list[count.toInt()]}")
            result.add(list.removeAt(count.toInt()))
        }
        return result.joinToString("")
    }
}


/*
 * 10! > 3 million
 *  to find the 1_000_000th permutation, we can see that
 * 0 [9!]
 * 1 [9!]
 * 2 [9!]
 * 3 [9!]
 * ..
 * Because 9! = 362_880, we need two full rounds of this serie-of-9 and then some partly round of this serie
 * therefore, we start with the 2.
 * We now need to look for the 1_000_000 - 2*362_880 = the 274240th number of the lexicon-permutation of <0,1,3,4,5,6,7,8,9>
 *   2 0 [8!-serie]
 *   2 1 [8!-serie]
 *   2 3 [8!-serie]   --> 2 already used
 *   ...
 * Since 8! = 40320, we have 7 of these serie-8 rounds.
 * Etc.
 */

//2783915460

