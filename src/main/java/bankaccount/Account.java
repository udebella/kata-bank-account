package bankaccount;

import bankaccount.history.DepositLine;
import bankaccount.history.HistoryLine;
import bankaccount.history.WithdrawLine;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private final List<HistoryLine> history = new ArrayList<>();

    /**
     * Allow to deposit an amount on the account
     * @param amount to deposit
     * @param operationDate date of the operation
     *
     * @throws IllegalArgumentException if amount is negative
     */
    public void deposit(Amount amount, LocalDate operationDate) {
        verifyPositiveAmount(amount);
        history.add(DepositLine.of(amount, operationDate, balance().add(amount)));
    }

    /**
     * Allow to withdraw an amount on the account
     * @param amount to withdraw
     * @param operationDate date of the operation
     *
     * @throws IllegalArgumentException if amount is negative
     */
    public void withdraw(Amount amount, LocalDate operationDate) {
        verifyPositiveAmount(amount);
        history.add(WithdrawLine.of(amount, operationDate, balance().add(amount.negative())));
    }

    private void verifyPositiveAmount(Amount amount) {
        if (amount.isNegative()) {
            throw new IllegalArgumentException("Negative amounts are not allowed");
        }
    }

    public void history(Printer printer) {
        printer.print("OPERATION | DATE | AMOUNT | BALANCE");
        history.forEach(historyLine -> historyLine.print(printer));
    }

    public Amount balance() {
        return history.stream()
                .reduce(Amount.ZERO, (amount, line) -> line.combineAmounts(amount), Amount::add);
    }
}
