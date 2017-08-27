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

    public void withdraw(Amount amount, LocalDate operationDate) {
    }

    public void history(Printer printer) {
        throw new UnsupportedOperationException();
    }

    public Amount balance() {
        return balance;
    }
}
