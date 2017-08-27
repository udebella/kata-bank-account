package bankaccount.history;

import bankaccount.Amount;

import java.time.LocalDate;

public class DepositLine extends HistoryLine {
    private DepositLine(Amount amount, LocalDate date, Amount currentBalance) {
        super(amount, date, currentBalance);
    }

    public static HistoryLine of(Amount amount, LocalDate operationDate, Amount balance) {
        return new DepositLine(amount, operationDate, balance);
    }

    @Override
    protected String printOperationType() {
        return "DEPOSIT";
    }

    public Amount combineAmounts(Amount amount) {
        return this.amount.add(amount);
    }
}
