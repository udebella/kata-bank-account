package bankaccount;

import bankaccount.Amount.AmountBuilder;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {
    @Test
    public void account_should_have_not_any_money_by_default() {
        final Account newAccount = new Account();

        assertThat(newAccount.accountBalance())
                .isEqualTo(new AmountBuilder().withValueAsCents(0).build());
    }

    @Test
    public void should_display_accounts() {
        final Account newAccount = new Account();

        assertThat(newAccount.toString()).isEqualTo("Account{amount=Amount{valueAsCents=0}}");
    }
}
