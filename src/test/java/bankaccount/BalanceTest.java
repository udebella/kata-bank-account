package bankaccount;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class BalanceTest {

    @Test
    public void balance_should_be_comparable() {
        assertThat(Balance.of(Amount.ZERO, true)).isEqualTo(Balance.of(Amount.ZERO, true));
    }
}