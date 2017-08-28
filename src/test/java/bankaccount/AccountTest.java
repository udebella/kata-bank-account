package bankaccount;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {
    private Account account;
    private Printer printer;
    private DateService dateService;

    @Before
    public void setUp() {
        dateService = Mockito.mock(DateService.class);
        account = new Account(dateService);
        printer = Mockito.mock(Printer.class);
    }

    @Test
    public void balance_should_be_zero_by_default() {
        assertThat(account.balance()).isEqualTo(Amount.ZERO);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deposit_should_not_allow_negative_amounts() {
        account.deposit(Amount.of(-10));
    }

    @Test
    public void deposit_should_update_account_balance() {
        account.deposit(Amount.of(10));

        assertThat(account.balance()).isEqualTo(Amount.of(10));
    }

    @Test
    public void multiple_deposit_should_update_account_balance() {
        account.deposit(Amount.of(10));
        account.deposit(Amount.of(10));

        assertThat(account.balance()).isEqualTo(Amount.of(20));
    }

    @Test
    public void multiple_deposit_of_different_amount_should_update_balance() {
        account.deposit(Amount.of(10));
        account.deposit(Amount.of(15));

        assertThat(account.balance()).isEqualTo(Amount.of(25));
    }

    @Test
    public void withdraw_nothing_should_not_update_balance() {
        account.withdraw(Amount.ZERO);

        assertThat(account.balance()).isEqualTo(Amount.ZERO);
    }

    @Test(expected = IllegalArgumentException.class)
    public void withdraw_should_not_allow_negative_amounts() {
        account.withdraw(Amount.of(-10));
    }

    @Test
    public void withdraw_should_update_account_balance() {
        account.withdraw(Amount.of(50));

        assertThat(account.balance()).isEqualTo(Amount.of(-50));
    }

    @Test
    public void multiple_withdraw_should_update_account_balance() {
        account.withdraw(Amount.of(50));
        account.withdraw(Amount.of(50));

        assertThat(account.balance()).isEqualTo(Amount.of(-100));
    }

    @Test
    public void history_should_print_a_description_line() {
        account.history(printer);

        Mockito.verify(printer).print("OPERATION | DATE | AMOUNT | BALANCE");
    }

    @Test
    public void history_should_keep_track_of_deposits() {
        Mockito.when(dateService.now())
                .thenReturn(LocalDate.of(2017, Month.AUGUST, 27));
        account.deposit(Amount.of(1000));
        account.history(printer);

        Mockito.verify(printer).print("DEPOSIT | 27/08/2017 | +10€ | +10€");
    }

    @Test
    public void history_should_keep_track_of_withdrawals() {
        Mockito.when(dateService.now())
                .thenReturn(LocalDate.of(2017, Month.AUGUST, 27));
        account.withdraw(Amount.of(1000));
        account.history(printer);

        Mockito.verify(printer).print("WITHDRAW | 27/08/2017 | +10€ | -10€");
    }
}
