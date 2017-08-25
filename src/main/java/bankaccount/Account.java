package bankaccount;

import java.time.LocalDate;

public class Account {
    public void deposit(Amount amount, LocalDate operationDate) {
        throw new UnsupportedOperationException();
    }

    public void withdraw(Amount amount, LocalDate operationDate) {
        throw new UnsupportedOperationException();
    }

    public void history(Printer printer) {
        throw new UnsupportedOperationException();
    }
}
