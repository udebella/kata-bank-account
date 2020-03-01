package com.bankaccount.domain.history;

import java.time.LocalDate;

public interface Printer {
    void print(String operationType, LocalDate operationDate, long amount, long balance);
}
