package com.bankaccount.domain;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

public class DepositTest {
    @Test
    void should_verify_equality() {
        EqualsVerifier.forClass(Deposit.class).verify();
    }
}
