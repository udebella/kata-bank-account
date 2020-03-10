package com.bankaccount.domain.money;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class AmountTest {
    @Test
    void should_verify_equality() {
        EqualsVerifier.forClass(Amount.class).verify();
    }

    @Test
    void should_not_allow_to_create_negative_amounts() {
        Assertions.assertThatThrownBy(() -> Amount.of(-10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Amounts cannot be negative");
    }

    @Test
    void should_allow_to_create_amounts() {
        assertThat(Amount.of(1)).isEqualTo(Amount.of(1));
    }

    @Test
    void should_allow_to_add_to_zero_amount() {
        final Amount amount = Amount.of(10);
        final Amount amount2 = Amount.of(0);

        final Balance balance = amount.add(amount2);

        assertThat(balance).isEqualTo(Balance.of(10));
    }

    @Test
    void should_allow_to_add_two_non_zero_amounts() {
        final Amount amount = Amount.of(10);
        final Amount amount2 = Amount.of(5);

        final Balance balance = amount.add(amount2);

        assertThat(balance).isEqualTo(Balance.of(15));
    }

    @Test
    void should_allow_to_subtract_to_zero_amount() {
        final Amount amount = Amount.of(10);
        final Amount amount2 = Amount.of(0);

        final Balance balance = amount.subtract(amount2);

        assertThat(balance).isEqualTo(Balance.of(10));
    }

    @Test
    void should_allow_to_subtract_two_non_zero_amounts() {
        final Amount amount = Amount.of(10);
        final Amount amount2 = Amount.of(5);

        final Balance balance = amount.subtract(amount2);

        assertThat(balance).isEqualTo(Balance.of(5));
    }

    @Test
    void should_allow_to_read_the_amount() {
        final Amount amount = Amount.of(10);
        final AmountReader amountReader = mock(AmountReader.class);

        amount.readAmount(amountReader);

        verify(amountReader).read(10);
    }
}