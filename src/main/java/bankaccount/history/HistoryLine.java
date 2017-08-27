package bankaccount.history;

import bankaccount.Amount;
import bankaccount.OperationType;
import bankaccount.Printer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class HistoryLine {
    private static final String SEPARATOR = " | ";
    private static final String CURRENCY = "€";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/YYYY");

    protected final OperationType operationType;
    protected final Amount amount;
    protected final LocalDate date;
    protected final Amount currentBalance;

    protected HistoryLine(OperationType operationType, Amount amount, LocalDate date, Amount currentBalance) {
        this.operationType = operationType;
        this.amount = amount;
        this.date = date;
        this.currentBalance = currentBalance;
    }

    public void print(Printer printer) {
        String lineRepresentation = operationType.toString()
                + SEPARATOR + FORMATTER.format(date)
                + SEPARATOR + amount.print() + CURRENCY
                + SEPARATOR + currentBalance.print() + CURRENCY;

        printer.print(lineRepresentation);
    }

    public abstract Amount combineAmounts(Amount amount);
}
