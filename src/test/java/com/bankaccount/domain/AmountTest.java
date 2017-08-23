package com.bankaccount.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AmountTest {
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
    public void should_convert_amount_to_negative_value() {
        final Amount amount = Amount.fromValue(100);

        assertThat(amount.negative())
                .isEqualTo(Amount.fromValue(-100));
    }
}
