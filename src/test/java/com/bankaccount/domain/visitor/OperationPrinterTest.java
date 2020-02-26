package com.bankaccount.domain.visitor;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class OperationPrinterTest {

    @Test
    void should_print_a_line() {
        final Printer printer = mock(Printer.class);
        final OperationPrinter operationPrinter = new OperationPrinter(printer);

        operationPrinter.readOperationType("Deposit");
        operationPrinter.readOperationDate(LocalDate.of(2020, Month.FEBRUARY, 23));
        operationPrinter.readAmount(10);
        operationPrinter.readBalance(10);
        operationPrinter.completeOperation();

        verify(printer).print("Deposit | 23/02/2020 | 10 | 10");
    }
}