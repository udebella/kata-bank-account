package com.bankaccount.domain;

import com.bankaccount.domain.money.Balance;
import com.bankaccount.domain.money.Amount;
import com.bankaccount.domain.operations.Deposit;
import com.bankaccount.domain.visitor.AccountVisitor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AccountTest {
    @Test
    void should_calculate_balance_for_a_new_account() {
        final Account account = new Account();

        final Balance balance = account.balance();

        assertThat(balance).isEqualTo(Balance.of(0));
    }

    @Test
    void should_calculate_balance_for_account_with_deposit() {
        final Account account = new Account(new Deposit(Amount.of(5), LocalDate.now()));

        final Balance balance = account.balance();

        assertThat(balance).isEqualTo(Balance.of(5));
    }

    @Test
    void should_calculate_balance_for_account_with_multiple_deposits() {
        final Account account = new Account(
                new Deposit(Amount.of(5), LocalDate.now()),
                new Deposit(Amount.of(7), LocalDate.now()));

        final Balance balance = account.balance();

        assertThat(balance).isEqualTo(Balance.of(12));
    }

    @Test
    void should_allow_to_read_an_account() {
        final Deposit operation = new Deposit(Amount.of(5), LocalDate.now());
        final Account account = new Account(operation);

        final AccountVisitor accountReader = mock(AccountVisitor.class);
        account.readAccount(accountReader);

        verify(accountReader).readOperation(operation);
    }
}
