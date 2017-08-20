package bankaccount;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountNumberTest {
    @Test
    public void same_account_numbers_should_be_equal() {
        assertThat(AccountNumber.fromNumber(1))
                .isEqualTo(AccountNumber.fromNumber(1));
    }
}
