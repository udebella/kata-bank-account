package bankaccount;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {
    @Test
    public void account_should_have_not_any_money_by_default() {
        final Account newAccount = new Account();

        assertThat(newAccount.accountBalance())
                .isEqualTo(Amount.fromValue(0));
    }

    @Test
    public void should_display_accounts() {
        final Account newAccount = new Account();

        assertThat(newAccount.toString()).isEqualTo("Account{amount=Amount{valueAsCents=0}}");
    }
}
