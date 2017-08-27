package bankaccount.history;

import bankaccount.Amount;
import bankaccount.OperationType;

import java.time.LocalDate;

public class DepositLine extends HistoryLine {
    private DepositLine(OperationType operationType, Amount amount, LocalDate date, Amount currentBalance) {
        super(operationType, amount, date, currentBalance);
    }

    public static HistoryLine of(OperationType deposit, Amount amount, LocalDate operationDate, Amount balance) {
        return new DepositLine(deposit, amount, operationDate, balance);
    }

    public Amount combineAmounts(Amount amount) {
        return this.amount.add(amount);
    }
}
