package com.bankaccount.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AmountTest {
    @Test(expected = IllegalStateException.class)
    public void should_not_allow_negative_amounts() {
        Amount.fromValue(-1);
    }

    @Test
    public void same_amounts_should_be_equal() {
        assertThat(Amount.fromValue(100))
                .isEqualTo(Amount.fromValue(100));
    }

    @Test
    public void should_allow_to_add_amounts() {
        final Amount amount = Amount.fromValue(100);

        final Amount addition = amount.add(Amount.fromValue(50));

        assertThat(addition)
                .isEqualTo(Amount.fromValue(150));
    }

    @Test
    public void should_display_amounts_properly() {
        final Amount amount = Amount.fromValue(100);

        assertThat(amount.toString())
                .isEqualTo("Amount{valueAsCents=100}");
    }
}
