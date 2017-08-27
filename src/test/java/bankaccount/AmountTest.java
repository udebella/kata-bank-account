package bankaccount;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AmountTest {
    @Test
    public void amount_should_be_comparable() {
        assertThat(Amount.of(10)).isEqualTo(Amount.of(10));
        assertThat(Amount.ZERO).isNotEqualTo(Amount.of(10));
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

    @Test
    public void amounts_should_be_able_to_be_negated() {
        assertThat(Amount.of(100).negative()).isEqualTo(Amount.of(-100));
    }

    @Test
    public void amounts_should_let_us_know_if_they_are_positive_or_negative() {
        assertThat(Amount.of(100).isNegative()).isFalse();
        assertThat(Amount.of(-100).isNegative()).isTrue();
    }

    @Test
    public void amounts_should_be_printable() {
        assertThat(Amount.ZERO.print()).isEqualTo("0");
    }

    @Test
    public void positive_amounts_should_not_print_as_cents() {
        assertThat(Amount.of(100).print()).isEqualTo("+1");
    }

    @Test
    public void negative_amounts_should_print_a_minus_symbol() {
        assertThat(Amount.of(-100).print()).isEqualTo("-1");
    }

    @Test
    public void cents_should_be_printed() {
        assertThat(Amount.of(53).print()).isEqualTo("+0,53");
    }
}
