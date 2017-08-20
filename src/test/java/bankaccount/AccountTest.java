package bankaccount;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {
    @Test
    public void should_display_accounts() {
        final Account newAccount = Account.fromAmount(Amount.fromValue(0));

        assertThat(newAccount.toString()).isEqualTo("Account{amount=Amount{valueAsCents=0}}");
    }
}
