package euler.problem000.problem031_040

import euler.EulerExecutable

class DoubleBasePalindromes: EulerExecutable {
    override val problemNumber = 36

    override fun solve(): Any {
        return (1..999_999)
            .filter{ it.toString().isPalindrome() }
            .filter{ it.toString(2).isPalindrome() }
            .sum()
    }

    private fun String.isPalindrome() = this.reversed() == this
}