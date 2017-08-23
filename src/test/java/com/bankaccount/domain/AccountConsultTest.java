package com.bankaccount.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountConsultTest {
    @Test
    public void account_should_have_creation_operation_by_default() {
        final Account account = Account.fromAmount(Amount.ZERO);

        assertThat(account.consult()).containsExactly(CreationOperation.fromAmount(Amount.ZERO));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void should_not_allow_to_modify_account_history() {
        final Account account = Account.fromAmount(Amount.ZERO);

        account.consult().add(CreationOperation.fromAmount(Amount.ZERO));
    }

    @Test
    public void history_should_keep_track_of_deposits() {
        final Account account = Account.fromAmount(Amount.ZERO);

        account.deposit(Amount.fromValue(10));

        assertThat(account.consult()).contains(DepositOperation.fromAmount(Amount.fromValue(10)));
    }

    @Test
    public void history_should_keep_track_of_withdrawal() {
        final Account account = Account.fromAmount(Amount.fromValue(100));

        account.withdraw(Amount.fromValue(10));

        assertThat(account.consult()).contains(WithdrawOperation.fromAmount(Amount.fromValue(-10)));
    }
}
