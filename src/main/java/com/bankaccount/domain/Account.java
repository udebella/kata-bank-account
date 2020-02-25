package com.bankaccount.domain;

import com.bankaccount.domain.money.Balance;
import com.bankaccount.domain.money.PositiveAmount;
import com.bankaccount.domain.operations.Deposit;
import com.bankaccount.domain.operations.Operation;
import com.bankaccount.domain.operations.Withdrawal;
import com.bankaccount.domain.visitor.AccountVisitor;

import java.time.LocalDate;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Account {
    private final List<Operation> operations;

    public Account(Operation... operations) {
        this.operations = Stream.of(operations).collect(Collectors.toList());
    }

    public Balance balance() {
        return operations.stream()
                .reduce(Balance.of(0),
                        (balance, operation) -> operation.applyOn(balance),
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
        this.operations.add(operation);
    }

    public void accept(AccountVisitor visitor) {
    }
}
