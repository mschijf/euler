package euler.problem000.problem011_020

fun longestCollatzSequence(): Any {
//    return (1..999_999L).maxBy { collatzSequenceLength(it) }
    return (500_000..999_999L).maxBy { collatzSequenceLength(it) }
}

private fun collatzSequenceLength(input: Long) : Int {
    var count = 1
    var n = input
    while (n != 1L) {
        count++
        n = if (n % 2 == 0L) n/2 else 3*n +1
    }
    return count
}

