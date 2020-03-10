package com.bankaccount.domain.history;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class HistoryPrinterTest {

    @Test
    void should_print_a_line() {
        final Printer printer = mock(Printer.class);
        final HistoryPrinter historyPrinter = new HistoryPrinter(printer);

        historyPrinter.readOperationType("Deposit");
        historyPrinter.readOperationDate(LocalDate.of(2020, Month.FEBRUARY, 23));
        historyPrinter.readAmount(10);
        historyPrinter.readBalance(10);
        historyPrinter.completeOperation();

        verify(printer).print("Deposit", LocalDate.of(2020, Month.FEBRUARY, 23), 10, 10);
    }
}