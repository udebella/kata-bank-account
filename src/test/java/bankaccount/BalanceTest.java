package bankaccount;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class BalanceTest {
    private Balance balance;

    @Before
    public void setUp() {
        balance = Balance.of(Amount.ZERO, true);
    }

    @Test
    public void balance_should_be_comparable() {
        assertThat(Balance.of(Amount.ZERO, true)).isEqualTo(Balance.of(Amount.ZERO, true));
    }

    @Test
    public void adding_zero_amount_to_balance_should_return_same_balance() {
        final Balance finalBalance = balance.add(Amount.ZERO);

        assertThat(finalBalance).isEqualTo(balance);
    }

    @Test
    public void adding_non_zero_amount_to_balance_should_update_balance() {
        final Amount amountToAdd = Amount.of(15);

        final Balance finalBalance = balance.add(amountToAdd);

        assertThat(finalBalance).isEqualTo(Balance.of(amountToAdd, true));
    }
}