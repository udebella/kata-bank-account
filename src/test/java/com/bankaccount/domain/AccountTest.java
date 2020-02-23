package com.bankaccount.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {
    @Test
    void should_calculate_balance_for_a_new_account() {
        final Account account = new Account();

        final Balance balance = account.balance();

        assertThat(balance).isEqualTo(new Balance(0));
    }

    @Test
    void should_calculate_balance_for_account_with_deposit() {
        final Account account = new Account(new Deposit(PositiveAmount.of(5), LocalDate.now()));

        final Balance balance = account.balance();

        assertThat(balance).isEqualTo(new Balance(5));
    }
}
