package bankaccount.bankaccount.history

import bankaccount.bankaccount.Amount
import java.time.LocalDate
import java.time.format.DateTimeFormatter

abstract class HistoryLine(
    public val amount: Amount,
    public val date: LocalDate,
    public val currentBalance: Amount
) {
    public abstract fun printOperationType(): String
    abstract fun combineAmounts(amount: Amount): Amount

    companion object {
        private const val SEPARATOR = " | "
        private val FORMATTER = DateTimeFormatter.ofPattern("dd/MM/YYYY")
    }
}
