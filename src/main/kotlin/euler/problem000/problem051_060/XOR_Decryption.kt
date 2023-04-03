package euler.problem000.problem051_060

import euler.EulerExecutable
import euler.getInputLinesFromFile

class XOR_Decryption: EulerExecutable {

    override fun solve(): Any {
        val letters = getInputLinesFromFile("data/p059_cipher.txt").first()
            .split(",")
            .map{it.toInt()}

        var passWord = ""
        var maxCount = -1
        for (c0 in 'a'..'z') {
            for (c1 in 'a'..'z') {
                for (c2 in 'a'..'z') {
                    val tmpPassword = "$c0$c1$c2"
                    val eCount = letters
                        .mapIndexed { index, letter -> letter xor tmpPassword[index % 3].code }
                        .count{ it.toChar().lowercase() == "e" }
                    if (eCount > maxCount) {
                        maxCount = eCount
                        passWord = tmpPassword
                    }
                }
            }
        }
        return letters.mapIndexed { index, letter ->  (letter xor passWord[index % 3].code)}.sum()
    }
}
