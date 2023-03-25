package euler.problem000.problem031_040

import euler.EulerExecutable

class ChampernownesConstant: EulerExecutable {
    // little complex solution (straightforward one is below out-commented
    // but saves memory
    override fun solve(): Any {
        var product = 1
        var checkIndex = 1
        var index = 1
        var integer = 1
        while (checkIndex <= 1_000_000) {
            val integerStr = integer.toString()
            if (index >= checkIndex) {
                product *= integerStr[index-checkIndex].digitToInt()
                checkIndex *= 10
            }
            index += integerStr.length
            integer++
        }
        return product
    }

// simple straightforward solution: put it all in a string (use stringbuilder!)
// string will become big (1_000_000 bytes)

//    override fun solve(): Any {
//        var s = StringBuilder("")
//        var i = 1;
//        while (s.length < 1_000_000) {
//            s.append(i)
//            i++
//        }
//        return s[0].digitToInt() * s[9].digitToInt() * s[99].digitToInt() * s[999].digitToInt() * s[9999].digitToInt() * s[99999].digitToInt()  * s[999999].digitToInt()
//    }


}