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

        LineHistory firstLine = LineHistory.of(CreationOperation.of(Amount.ZERO, now), Amount.ZERO);
        assertThat(account.consult()).containsExactly(firstLine);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void should_not_allow_to_modify_account_history() {
        final Account account = Account.of(Amount.ZERO, LocalDateTime.now());

        final LineHistory firstLine = LineHistory.of(CreationOperation.of(Amount.ZERO, LocalDateTime.now()), Amount.ZERO);
        account.consult().add(firstLine);
    }

    @Test
    public void history_should_keep_track_of_deposits() {
        final Account account = Account.of(Amount.ZERO, LocalDateTime.now());

        final LocalDateTime now = LocalDateTime.now();
        account.deposit(Amount.of(10), now);

        final LineHistory depositLine = LineHistory.of(DepositOperation.of(Amount.of(10), now), Amount.ZERO);
        assertThat(account.consult()).contains(depositLine);
    }

    @Test
    public void history_should_keep_track_of_withdrawal() {
        final Account account = Account.of(Amount.of(100), LocalDateTime.now());

        final LocalDateTime now = LocalDateTime.now();
        account.withdraw(Amount.of(10), now);

        final LineHistory withdrawalLine = LineHistory.of(WithdrawOperation.of(Amount.of(10), now), Amount.of(100));
        assertThat(account.consult()).contains(withdrawalLine);
    }
}
