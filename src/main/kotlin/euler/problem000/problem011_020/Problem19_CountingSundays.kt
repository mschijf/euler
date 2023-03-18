package euler.problem000.problem011_020

import java.time.DayOfWeek
import java.time.LocalDate

fun countingSundays(): Any {
    var count = 0
    var date = LocalDate.of(1901, 1, 1)
    while (date.year != 2001) {
        if (date.dayOfMonth == 1 && date.dayOfWeek == DayOfWeek.SUNDAY)
            count++
        date = date.plusDays(1)
    }
    return count
}

