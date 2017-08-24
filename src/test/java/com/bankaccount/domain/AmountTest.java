package com.bankaccount.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AmountTest {
    @Test
    public void same_amounts_should_be_equal() {
        assertThat(Amount.of(100))
                .isEqualTo(Amount.of(100));
    }

    @Test
    public void should_allow_to_add_amounts() {
        final Amount amount = Amount.of(100);

        final Amount addition = amount.add(Amount.of(50));

        assertThat(addition)
                .isEqualTo(Amount.of(150));
    }

    @Test
    public void should_convert_amount_to_negative_value() {
        final Amount amount = Amount.of(100);

        assertThat(amount.negative())
                .isEqualTo(Amount.of(-100));
    }
}
