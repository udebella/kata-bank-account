package com.bankaccount.domain.visitor;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class PrinterVisitorTest {

    @Test
    void should_print_a_line() {
        final Printer printer = mock(Printer.class);
        final PrinterVisitor visitor = new PrinterVisitor(printer);

        visitor.readOperation("Deposit", LocalDate.of(2020, Month.FEBRUARY, 23));
        visitor.readAmount(10);
        visitor.readBalance(10);
        visitor.flush();

        verify(printer).print("Deposit | 23/02/2020 | 10 | 10");
    }
}