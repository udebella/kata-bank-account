package com.bankaccount.domain;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountDepositTest {
    private Account account;

    @Before
    public void setUp() throws Exception {
        account = Account.of(Amount.ZERO, LocalDateTime.now());
    }

    @Test
    public void deposit_should_update_account_balance() {
        account.deposit(Amount.of(10), LocalDateTime.now());

        assertThat(account.accountBalance())
                .isEqualTo(Amount.of(10));
    }

    @Test
    public void depositing_two_times_in_a_row_on_the_same_account_should_update_the_account() {
        account.deposit(Amount.of(10), LocalDateTime.now());
        account.deposit(Amount.of(10), LocalDateTime.now());

        assertThat(account.accountBalance())
                .isEqualTo(Amount.of(20));
    }
}
