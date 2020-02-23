package com.bankaccount.domain;

import java.util.Arrays;
import java.util.List;

public class Account {
    private final List<Deposit> deposits;

    public Account(Deposit... deposits) {
        this.deposits = Arrays.asList(deposits);
    }

    public Balance balance() {
        return deposits.stream()
                .reduce(new Balance(0),
                        (balance, deposit) -> deposit.applyOn(balance),
                        (balance, balance2) -> {throw new RuntimeException("Need implementation");});
    }

    public void deposit(PositiveAmount amount) {

    }
}
