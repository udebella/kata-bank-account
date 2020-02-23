package com.bankaccount.domain;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

class AmountTest {
    @Test
    void should_verify_equality() {
        EqualsVerifier.forClass(Amount.class).verify();
    }
}