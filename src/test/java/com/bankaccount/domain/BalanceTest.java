package com.bankaccount.domain;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BalanceTest {
    @Test
    void should_verify_equality() {
        EqualsVerifier.forClass(Balance.class).verify();
    }

    @Test
    void should_allow_to_add_amounts_to_a_balance() {
        final Balance balance = Balance.of(0);

        final Balance result = balance.add(PositiveAmount.of(5));

        assertThat(result).isEqualTo(Balance.of(5));
    }

    @Test
    void should_allow_to_create_negative_balances() {
        Balance.of(-5);
    }

    @Test
    void should_allow_to_subtract_amount() {
        final Balance balance = Balance.of(10);

        final Balance result = balance.subtract(PositiveAmount.of(5));

        assertThat(result).isEqualTo(Balance.of(5));
    }
}