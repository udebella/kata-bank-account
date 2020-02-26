package com.bankaccount.domain.money;

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

        final Balance result = balance.add(Amount.of(5));

        assertThat(result).isEqualTo(Balance.of(5));
    }

    @Test
    void should_provide_an_empty_balance() {
        assertThat(Balance.INITIAL).isEqualTo(Balance.of(0));
    }

    @Test
    void should_allow_to_create_negative_balances() {
        Balance.of(-5);
    }

    @Test
    void should_allow_to_subtract_amount() {
        final Balance balance = Balance.of(10);

        final Balance result = balance.subtract(Amount.of(5));

        assertThat(result).isEqualTo(Balance.of(5));
    }

    @Test
    void should_properly_add_when_balance_is_negative() {
        final Balance balance = Balance.of(-5);

        final Balance result = balance.add(Amount.of(10));

        assertThat(result).isEqualTo(Balance.of(5));
    }

    @Test
    void should_properly_subtract_when_balance_is_negative() {
        final Balance balance = Balance.of(-5);

        final Balance result = balance.subtract(Amount.of(10));

        assertThat(result).isEqualTo(Balance.of(-15));
    }
}