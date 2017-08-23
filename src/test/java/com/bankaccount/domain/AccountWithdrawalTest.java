package com.bankaccount.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class AccountWithdrawalTest {
    @Test
    public void should_retrieve_amount_from_account_balance() {
        Account account = Account.fromAmount(Amount.fromValue(100));

        account.withdraw(Amount.fromValue(10));

        Assertions.assertThat(account.accountBalance()).isEqualTo(Amount.fromValue(90));
    }
}
