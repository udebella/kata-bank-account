package bankaccount;

import java.time.LocalDate;

public class Account {
    private Amount balance = Amount.ZERO;

    public void deposit(Amount amount, LocalDate operationDate) {
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
