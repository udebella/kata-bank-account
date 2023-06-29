package bankaccount.bankaccount

import java.time.LocalDate
import java.time.format.DateTimeFormatter

abstract class HistoryLine(
    protected val amount: Amount,
    protected val date: LocalDate,
    protected val currentBalance: Amount
) {
    fun print(printer: Printer) {
        val lineRepresentation = (printOperationType()
                + SEPARATOR + FORMATTER.format(date)
                + SEPARATOR + amount.print()
                + SEPARATOR + currentBalance.print())
        printer.print(lineRepresentation)
    }

    protected abstract fun printOperationType(): String
    abstract fun combineAmounts(amount: Amount): Amount

    companion object {
        private const val SEPARATOR = " | "
        private val FORMATTER = DateTimeFormatter.ofPattern("dd/MM/YYYY")
    }
}
