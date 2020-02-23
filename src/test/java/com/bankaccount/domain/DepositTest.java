package com.bankaccount.domain;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class DepositTest {
    @Test
    void should_verify_equality() {
        EqualsVerifier.forClass(Deposit.class).verify();
    }

    @Test
    void should_apply_deposit_on_balances() {
        final Deposit deposit = new Deposit(PositiveAmount.of(5), LocalDate.now());
        final Balance balance = Balance.of(10);

        final Balance result = deposit.applyOn(balance);

        assertThat(result).isEqualTo(Balance.of(15));
    }
}
