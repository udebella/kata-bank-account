package com.bankaccount.domain;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private final List<Deposit> deposits = new ArrayList<>();

    public Account() {}

    public Account(Deposit deposit) {
        this.deposits.add(deposit);
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
