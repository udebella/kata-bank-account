package com.bankaccount.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDateTime;

public class AccountWithdrawalTest {
    @Test
    public void should_retrieve_amount_from_account_balance() {
        Account account = Account.of(Amount.of(100), LocalDateTime.now());

        account.withdraw(Amount.of(10), LocalDateTime.now());

        assertThat(account.accountBalance()).isEqualTo(Amount.of(90));
    }
}
