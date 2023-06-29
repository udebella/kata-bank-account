package bankaccount.bankaccount

import java.time.LocalDate

class DepositLine private constructor(amount: Amount, date: LocalDate, currentBalance: Amount) :
    HistoryLine(amount, date, currentBalance) {
    override fun printOperationType(): String {
        return "DEPOSIT"
    }

    override fun combineAmounts(amount: Amount): Amount {
        return this.amount.add(amount)
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
            return DepositLine(amount, operationDate, balance)
        }
    }
}
