package bankaccount;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {
    private Account account;

    @Before
    public void setUp() throws Exception {
        account = new Account();
    }

    @Test
    public void balance_should_be_zero_by_default() {
        assertThat(account.balance()).isEqualTo(Amount.of(0));
    }
}
