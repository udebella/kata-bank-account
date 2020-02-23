package com.bankaccount.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {
    @Test
    void should_calculate_balance_for_a_new_account() {
        final Account account = new Account();

        final Balance balance = account.balance();

        assertThat(balance).isEqualTo(new Balance(0));
    }
}
