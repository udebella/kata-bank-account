package bankaccount;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.time.Month;

public class BankAccountFeature {
    private Printer printer;
    private DateService dateService;

    @BeforeEach
    public void setUp() {
        printer = Mockito.mock(Printer.class);
        dateService = Mockito.mock(DateService.class);
    }

    @Test
    public void deposit_and_withdrawal_on_accounts() {
        Mockito.when(dateService.now())
                .thenReturn(
                        LocalDate.of(2017, Month.AUGUST, 25),
                        LocalDate.of(2017, Month.AUGUST, 26),
                        LocalDate.of(2017, Month.AUGUST, 30));
        Account account = new Account(dateService);

        account.deposit(Amount.of(1000));
        account.withdraw(Amount.of(500));
        account.deposit(Amount.of(5000));

        account.history(printer);

        Mockito.verify(printer).print("OPERATION | DATE | AMOUNT | BALANCE");
        Mockito.verify(printer).print("DEPOSIT | 25/08/2017 | +10€ | +10€");
        Mockito.verify(printer).print("WITHDRAW | 26/08/2017 | +5€ | +5€");
        Mockito.verify(printer).print("DEPOSIT | 30/08/2017 | +50€ | +55€");
    }
}
