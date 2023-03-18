package euler.problem000.problem011_020

fun numberLetterCounts(): Any {
    val nw = NumberWord()
    return (1..1000).sumOf { nw.toWord(it).count { ch -> ch != ' ' && ch != '-' } }
}
