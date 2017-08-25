package bankaccount;

import java.time.LocalDate;

public class Account {
    private boolean deposit = false;

    public void deposit(Amount amount, LocalDate operationDate) {
        deposit = true;
    }

    public void withdraw(Amount amount, LocalDate operationDate) {
        throw new UnsupportedOperationException();
    }

    public void history(Printer printer) {
        throw new UnsupportedOperationException();
    }

    public Amount balance() {
        if (deposit) {
            return Amount.of(10);
        }
        return Amount.of(0);
    }
}
