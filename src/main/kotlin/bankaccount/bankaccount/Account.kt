package bankaccount.bankaccount

import java.util.function.Consumer

class Account(private val dateService: DateService) {
    private val history: MutableList<HistoryLine> = ArrayList()
    fun deposit(amount: Amount) {
        verifyPositiveAmount(amount)
        history.add(DepositLine.of(amount, dateService.now(), balance().add(amount)))
    }

    fun withdraw(amount: Amount) {
        verifyPositiveAmount(amount)
        history.add(WithdrawLine.of(amount, dateService.now(), balance().add(amount.negative())))
    }

    private fun verifyPositiveAmount(amount: Amount) {
        require(!amount.isNegative) { "Negative amounts are not allowed" }
    }

    fun history(): List<HistoryLine> {
        return history
    }

    fun balance(): Amount {
        return history.stream()
            .reduce(
                Amount.ZERO,
                { amount: Amount, line: HistoryLine -> line.combineAmounts(amount) }) { obj: Amount, amountToAdd: Amount ->
                obj.add(amountToAdd)
            }
    }
}
