package bankaccount;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private Amount balance = Amount.ZERO;
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
        history.add(HistoryLine.of(OperationType.DEPOSIT, amount, operationDate, balance().add(amount)));
        balance = balance.add(amount);
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
        history.add(HistoryLine.of(OperationType.WITHDRAW, amount, operationDate, balance().add(amount.negative())));
        balance = balance.add(amount.negative());
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
        return balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }
}
