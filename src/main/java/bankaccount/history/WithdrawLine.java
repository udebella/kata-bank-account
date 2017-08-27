package bankaccount.history;

import bankaccount.Amount;

import java.time.LocalDate;

public class WithdrawLine extends HistoryLine {
    private WithdrawLine(Amount amount, LocalDate date, Amount currentBalance) {
        super(amount, date, currentBalance);
    }

    public static HistoryLine of(Amount amount, LocalDate operationDate, Amount balance) {
        return new WithdrawLine(amount, operationDate, balance);
    }

    @Override
    protected String printOperationType() {
        return "WITHDRAW";
    }

    public Amount combineAmounts(Amount amount) {
        return this.amount.negative().add(amount);
    }
}
