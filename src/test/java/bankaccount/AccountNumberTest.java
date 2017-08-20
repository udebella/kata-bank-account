package bankaccount;

import bankaccount.AccountNumber.AccountNumberBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountNumberTest {
    private AccountNumberBuilder accountNumberBuilder;

    @Before
    public void setUp() {
        accountNumberBuilder = new AccountNumberBuilder();
    }

    @Test
    public void same_account_numbers_should_be_equal() {
        assertThat(new AccountNumberBuilder().withNumber(1).build())
                .isEqualTo(accountNumberBuilder.withNumber(1).build());
    }
}
