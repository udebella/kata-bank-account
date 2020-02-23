package com.bankaccount.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.function.BiFunction;
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
        this.applyOperation(Deposit::new, amount);
    }

    public void withdraw(PositiveAmount amount) {
        this.applyOperation(Withdrawal::new, amount);
    }

    private void applyOperation(BiFunction<PositiveAmount, LocalDate, Operation> operationConstructor, PositiveAmount amount) {
        final Operation operation = operationConstructor.apply(amount, LocalDate.now());
        this.deposits.add(operation);
    }
}
