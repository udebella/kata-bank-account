package bankaccount;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountDepositTest {
    private Account account;

    @Before
    public void setUp() throws Exception {
        account = Account.fromAmount(Amount.NULL_AMOUNT);
    }

    @Test
    public void deposit_should_update_account_balance() {
        account.deposit(Amount.fromValue(10));

        assertThat(account.accountBalance())
                .isEqualTo(Amount.fromValue(10));
    }

    @Test
    public void depositing_two_times_in_a_row_on_the_same_account_should_update_the_account() {
        account.deposit(Amount.fromValue(10));
        account.deposit(Amount.fromValue(10));

        assertThat(account.accountBalance())
                .isEqualTo(Amount.fromValue(20));
    }
}
