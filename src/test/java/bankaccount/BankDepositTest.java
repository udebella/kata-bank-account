package bankaccount;

import bankaccount.Amount.AmountBuilder;
import org.junit.Before;
import org.junit.Test;

import static bankaccount.AccountNumber.AccountNumberBuilder;
import static org.assertj.core.api.Assertions.assertThat;

public class BankDepositTest {
    private Bank bank;

    @Before
    public void setUp() {
        bank = new Bank();
    }

    @Test
    public void deposit_should_update_account_balance() {
        final Amount amount = new AmountBuilder()
                .withValueAsCents(10)
                .build();

        Account account = bank.makeDeposit(new AccountNumberBuilder().withNumber(1).build(), amount);

        assertThat(account.accountBalance())
                .isEqualTo(new AmountBuilder().withValueAsCents(10).build());
    }

    @Test
    public void depositing_two_times_in_a_row_on_the_same_account_should_update_the_account() {
        final Amount amount = new AmountBuilder()
                .withValueAsCents(10)
                .build();

        bank.makeDeposit(new AccountNumberBuilder().withNumber(1).build(), amount);
        Account account = bank.makeDeposit(new AccountNumberBuilder().withNumber(1).build(), amount);

        assertThat(account.accountBalance())
                .isEqualTo(new AmountBuilder().withValueAsCents(20).build());
    }
}
