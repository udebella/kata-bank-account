package bankaccount.bankaccount.history

import bankaccount.bankaccount.Amount
import java.time.LocalDate

class WithdrawLine private constructor(amount: Amount, date: LocalDate, currentBalance: Amount) :
    HistoryLine(amount, date, currentBalance) {
    override fun printOperationType(): String {
        return "WITHDRAW"
    }

    override fun combineAmounts(amount: Amount): Amount {
        return this.amount.negative().add(amount)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        return javaClass == other?.javaClass
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }

    companion object {
        fun of(amount: Amount, operationDate: LocalDate, balance: Amount): HistoryLine {
            return WithdrawLine(amount, operationDate, balance)
        }
    }
}
