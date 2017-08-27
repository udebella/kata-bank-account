package bankaccount;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.time.Month;

public class BankAccountFeature {
    private Printer printer;

    @Before
    public void setUp() {
        printer = Mockito.mock(Printer.class);
    }

    @Test
    public void deposit_and_withdrawal_on_accounts() {
        Account account = new Account();

        account.deposit(Amount.of(1000), LocalDate.of(2017, Month.AUGUST, 25));
        account.withdraw(Amount.of(500), LocalDate.of(2017, Month.AUGUST, 26));
        account.deposit(Amount.of(5000), LocalDate.of(2017, Month.AUGUST, 30));

        account.history(printer);

        Mockito.verify(printer).print("OPERATION | DATE | AMOUNT | BALANCE");
        Mockito.verify(printer).print("DEPOSIT | 25/08/2017 | +10€ | +10€");
        Mockito.verify(printer).print("WITHDRAW | 26/08/2017 | +5€ | +5€");
        Mockito.verify(printer).print("DEPOSIT | 30/08/2017 | +50€ | +55€");
    }
}
