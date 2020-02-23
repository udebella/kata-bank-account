package com.bankaccount.domain;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
}