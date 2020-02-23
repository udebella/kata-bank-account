package com.bankaccount.domain;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class WithdrawalTest {
    @Test
    void should_verify_equality() {
        EqualsVerifier.forClass(Withdrawal.class).verify();
    }

    @Test
    void should_apply_withdrawal_on_balances() {
        final Withdrawal withdrawal = new Withdrawal(PositiveAmount.of(5), LocalDate.now());
        final Balance balance = Balance.of(10);

        final Balance result = withdrawal.applyOn(balance);

        assertThat(result).isEqualTo(Balance.of(5));
    }
}