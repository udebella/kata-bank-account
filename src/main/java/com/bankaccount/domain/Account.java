package com.bankaccount.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Account {
    private final List<Operation> deposits;

    public Account(Operation... deposits) {
        this.deposits = Stream.of(deposits).collect(Collectors.toList());
    }

    public Balance balance() {
        return deposits.stream()
                .reduce(Balance.of(0),
                        (balance, deposit) -> deposit.applyOn(balance),
                        (balance, balance2) -> {throw new RuntimeException("Need implementation");});
    }

    public void deposit(PositiveAmount amount) {
        final Deposit deposit = new Deposit(amount, LocalDate.now());
        this.deposits.add(deposit);
    }

    public void withdraw(PositiveAmount amount) {
        final Withdrawal withdrawal = new Withdrawal(amount, LocalDate.now());
        this.deposits.add(withdrawal);
    }
}
