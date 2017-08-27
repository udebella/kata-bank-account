package bankaccount.history;

import bankaccount.Amount;
import bankaccount.OperationType;

import java.time.LocalDate;

public class WithdrawLine extends HistoryLine {
    private WithdrawLine(OperationType operationType, Amount amount, LocalDate date, Amount currentBalance) {
        super(operationType, amount, date, currentBalance);
    }

    public static HistoryLine of(OperationType deposit, Amount amount, LocalDate operationDate, Amount balance) {
        return new WithdrawLine(deposit, amount, operationDate, balance);
    }

    public Amount combineAmounts(Amount amount) {
        return this.amount.negative().add(amount);
    }
}
