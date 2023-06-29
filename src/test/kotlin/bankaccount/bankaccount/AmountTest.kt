package bankaccount.bankaccount

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class AmountTest {
    @Test
    fun amount_should_be_comparable() {
        Assertions.assertThat(Amount.of(10)).isEqualTo(Amount.of(10))
        Assertions.assertThat(Amount.ZERO).isNotEqualTo(Amount.of(10))
    }

    @Test
    fun adding_zero_to_zero_should_produce_zero() {
        val addAmount = Amount.ZERO.add(Amount.ZERO)
        Assertions.assertThat(addAmount).isEqualTo(Amount.ZERO)
    }

    @Test
    fun adding_some_amount_to_zero_should_produce_initial_amount() {
        val addAmount = Amount.ZERO.add(Amount.of(10))
        Assertions.assertThat(addAmount).isEqualTo(Amount.of(10))
    }

    @Test
    fun add_two_different_amounts_should_produce_sum() {
        val addAmount = Amount.of(20).add(Amount.of(10))
        Assertions.assertThat(addAmount).isEqualTo(Amount.of(30))
    }

    @Test
    fun amounts_should_be_able_to_be_negated() {
        Assertions.assertThat(Amount.of(100).negative()).isEqualTo(Amount.of(-100))
    }

    @Test
    fun amounts_should_let_us_know_if_they_are_positive_or_negative() {
        Assertions.assertThat(Amount.of(100).isNegative).isFalse()
        Assertions.assertThat(Amount.of(-100).isNegative).isTrue()
    }

    @Test
    fun amounts_should_be_printable() {
        Assertions.assertThat(Amount.ZERO.print()).isEqualTo("0€")
    }

    @Test
    fun positive_amounts_should_not_print_as_cents() {
        Assertions.assertThat(Amount.of(100).print()).isEqualTo("+1€")
    }

    @Test
    fun negative_amounts_should_print_a_minus_symbol() {
        Assertions.assertThat(Amount.of(-100).print()).isEqualTo("-1€")
    }

    @Test
    fun cents_should_be_printed() {
        Assertions.assertThat(Amount.of(53).print()).isEqualTo("+0,53€")
    }
}
