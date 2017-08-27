package bankaccount;

import java.time.LocalDate;

public class Account {
    private Amount balance = Amount.ZERO;

    /**
     * Allow to deposit an amount on the account
     * @param amount to deposit
     * @param operationDate date of the operation
     *
     * @throws IllegalArgumentException if amount is negative
     */
    public void deposit(Amount amount, LocalDate operationDate) {
        if (amount.isNegative()) {
            throw new IllegalArgumentException("Negative amounts are not allowed");
        }
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
        if (amount.isNegative()) {
            throw new IllegalArgumentException("Negative amounts are not allowed");
        }
        balance = balance.add(amount.negative());
    }

    public void history(Printer printer) {
        printer.print("OPERATION | DATE | AMOUNT | BALANCE");
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
