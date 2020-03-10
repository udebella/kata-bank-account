package com.bankaccount.domain.operations;

import com.bankaccount.domain.money.Amount;
import com.bankaccount.domain.money.Balance;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DepositTest {
    @Test
    void should_verify_equality() {
        EqualsVerifier.forClass(Deposit.class).verify();
    }

    @Test
    void should_apply_deposit_on_balances() {
        final Deposit deposit = new Deposit(Amount.of(5), LocalDate.now());
        final Balance balance = Balance.of(10);

        final Balance result = deposit.applyOn(balance);

        assertThat(result).isEqualTo(Balance.of(15));
    }

    @Test
    void should_allow_to_read_operation() {
        final Amount amount = Amount.of(5);
        final LocalDate date = LocalDate.now();
        final Deposit deposit = new Deposit(amount, date);
        final OperationReader operationReader = mock(OperationReader.class);

        deposit.readOperation(operationReader);

        verify(operationReader).readOperationType("Deposit");
        verify(operationReader).readAmount(amount);
        verify(operationReader).readOperationDate(date);
    }
}
