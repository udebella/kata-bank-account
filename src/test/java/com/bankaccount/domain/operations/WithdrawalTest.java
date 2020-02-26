package com.bankaccount.domain.operations;

import com.bankaccount.domain.money.Balance;
import com.bankaccount.domain.money.Amount;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class WithdrawalTest {
    @Test
    void should_verify_equality() {
        EqualsVerifier.forClass(Withdrawal.class).verify();
    }

    @Test
    void should_apply_withdrawal_on_balances() {
        final Withdrawal withdrawal = new Withdrawal(Amount.of(5), LocalDate.now());
        final Balance balance = Balance.of(10);

        final Balance result = withdrawal.applyOn(balance);

        assertThat(result).isEqualTo(Balance.of(5));
    }

    @Test
    void should_allow_to_read_operation() {
        final Amount amount = Amount.of(5);
        final LocalDate date = LocalDate.now();
        final Withdrawal withdrawal = new Withdrawal(amount, date);
        final OperationReader operationReader = mock(OperationReader.class);

        withdrawal.readOperation(operationReader);

        verify(operationReader).readOperationType("Withdrawal");
        verify(operationReader).readAmount(amount);
        verify(operationReader).readOperationDate(date);
    }
}