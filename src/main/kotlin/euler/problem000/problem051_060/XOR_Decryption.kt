package euler.problem000.problem051_060

import euler.EulerExecutable
import euler.getInputLinesFromFile

class XOR_Decryption: EulerExecutable {

    override fun solve(): Any {
        val letters = getInputLinesFromFile("data/p059_cipher.txt").first()
            .split(",")
            .map{it.toInt()}

        var password = ""
        var maxCount = 0
        for (c0 in 'a'..'z') {
            for (c1 in 'a'..'z') {
                for (c2 in 'a'..'z') {
                    val tmpPassword = "$c0$c1$c2"
                    val eCount = letters.decrypt(tmpPassword).count{ it.toChar().lowercase() == "e" }
                    if (eCount > maxCount) {
                        maxCount = eCount
                        password = tmpPassword
                    }
                }
            }
        }
        return letters.mapIndexed { index, letter ->  (letter xor password[index % password.length].code)}.sum()
    }

    private fun List<Int>.decrypt(cypherKey: String): List<Int> {
        return this.mapIndexed { index, letter -> letter xor cypherKey[index % cypherKey.length].code }
    }
}
