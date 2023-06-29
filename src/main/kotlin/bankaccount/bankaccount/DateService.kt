package bankaccount.bankaccount

import java.time.LocalDate

fun interface DateService {
    fun now(): LocalDate
}
