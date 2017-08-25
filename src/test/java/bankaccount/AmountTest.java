package bankaccount;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AmountTest {
    @Test
    public void amount_should_be_comparable() {
        assertThat(Amount.of(10)).isEqualTo(Amount.of(10));
        assertThat(Amount.ZERO).isNotEqualTo(Amount.of(10));
    }

    @Test(expected = IllegalArgumentException.class)
    public void amount_should_not_be_negative() {
        Amount.of(-10);
    }

    @Test
    public void adding_zero_to_zero_should_produce_zero() {
        final Amount addAmount = Amount.ZERO.add(Amount.ZERO);

        assertThat(addAmount).isEqualTo(Amount.ZERO);
    }

    @Test
    public void adding_some_amount_to_zero_should_produce_initial_amount() {
        final Amount addAmount = Amount.ZERO.add(Amount.of(10));

        assertThat(addAmount).isEqualTo(Amount.of(10));
    }

    @Test
    public void add_two_different_amounts_should_produce_sum() {
        final Amount addAmount = Amount.of(20).add(Amount.of(10));

        assertThat(addAmount).isEqualTo(Amount.of(30));
    }
}
