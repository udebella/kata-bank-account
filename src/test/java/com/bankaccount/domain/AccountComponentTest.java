package com.bankaccount.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountComponentTest {
    @Test
    void should_allow_deposits() {
        final Account account = new Account();

        account.deposit(new Amount(10));

        Assertions.assertThat(account.balance()).isEqualTo(new Balance(10));
    }
}
