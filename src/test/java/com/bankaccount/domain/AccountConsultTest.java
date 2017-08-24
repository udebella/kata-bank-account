package com.bankaccount.domain;

import com.bankaccount.domain.operations.CreationOperation;
import com.bankaccount.domain.operations.DepositOperation;
import com.bankaccount.domain.operations.WithdrawOperation;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountConsultTest {
    @Test
    public void account_should_have_creation_operation_by_default() {
        final LocalDateTime now = LocalDateTime.now();
        final Account account = Account.of(Amount.ZERO, now);

        assertThat(account.consult()).containsExactly(CreationOperation.of(Amount.ZERO, now));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void should_not_allow_to_modify_account_history() {
        final Account account = Account.of(Amount.ZERO, LocalDateTime.now());

        account.consult().add(CreationOperation.of(Amount.ZERO, LocalDateTime.now()));
    }

    @Test
    public void history_should_keep_track_of_deposits() {
        final Account account = Account.of(Amount.ZERO, LocalDateTime.now());

        final LocalDateTime now = LocalDateTime.now();
        account.deposit(Amount.of(10), now);

        assertThat(account.consult()).contains(DepositOperation.of(Amount.of(10), now));
    }

    @Test
    public void history_should_keep_track_of_withdrawal() {
        final Account account = Account.of(Amount.of(100), LocalDateTime.now());

        final LocalDateTime now = LocalDateTime.now();
        account.withdraw(Amount.of(10), now);

        assertThat(account.consult()).contains(WithdrawOperation.of(Amount.of(10), now));
    }
}
