package euler.problem000.problem011_020

fun powerDigitSum(): Any {
    val number = IntArray(1000){0}
    number[0] = 1
    repeat(1000) {
        var i=0
        var carrier = 0
        while (i < 999){
            val x = number[i]
            number[i] = (x * 2 + carrier) % 10
            carrier = (x * 2 + carrier) / 10
            i++
        }
        number[i] = carrier
    }
//    println(number.take(number.indexOfLast { it != 0 } + 1).reversed().joinToString(""))
    return number.sum()
}



