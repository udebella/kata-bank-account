package com.bankaccount.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.LocalDateTime;

public class AccountWithdrawalTest {
    @Test
    public void should_retrieve_amount_from_account_balance() {
        Account account = Account.of(Amount.of(100), LocalDateTime.now());

        account.withdraw(Amount.of(10), LocalDateTime.now());

        Assertions.assertThat(account.accountBalance()).isEqualTo(Amount.of(90));
    }
}
