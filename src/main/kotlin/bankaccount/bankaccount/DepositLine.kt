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

    companion object {
        fun of(amount: Amount, operationDate: LocalDate, balance: Amount): HistoryLine {
            return DepositLine(amount, operationDate, balance)
        }
    }
}
