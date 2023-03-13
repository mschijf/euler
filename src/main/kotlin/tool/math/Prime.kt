package tool.math

/**
 * returns a list of all primes below 'n'
 */
fun getPrimeList(n: Int): List<Int> {
    val strainer = Array(n){true}
    val primeList = mutableListOf<Int>()

    var i = 1
    while (i < n) {
        i++
        while (i < n && !strainer[i])
            i++
        if (i < n) {
            primeList.add(i)
            for (j in 2 * i until n step i)
                strainer[j] = false
        }
    }
    return primeList
}
