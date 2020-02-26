package com.bankaccount.domain.money;

@FunctionalInterface
public interface AmountReader {
    void read(long amount);
}
