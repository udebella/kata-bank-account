package bankaccount.bankaccount

import java.time.LocalDate

class WithdrawLine private constructor(amount: Amount, date: LocalDate, currentBalance: Amount) :
    HistoryLine(amount, date, currentBalance) {
    override fun printOperationType(): String {
        return "WITHDRAW"
    }

    override fun combineAmounts(amount: Amount): Amount {
        return this.amount.negative().add(amount)
    }

    companion object {
        fun of(amount: Amount, operationDate: LocalDate, balance: Amount): HistoryLine {
            return WithdrawLine(amount, operationDate, balance)
        }
    }
}
