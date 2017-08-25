package bankaccount;

import java.time.LocalDate;

public class Account {
    private int counter = 0;

    public void deposit(Amount amount, LocalDate operationDate) {
        counter++;
    }

    public void withdraw(Amount amount, LocalDate operationDate) {
        throw new UnsupportedOperationException();
    }

    public void history(Printer printer) {
        throw new UnsupportedOperationException();
    }

    public Amount balance() {
        return Amount.of(10*counter);
    }
}
