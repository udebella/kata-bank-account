package bankaccount.history;

import bankaccount.Amount;
import bankaccount.Printer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class HistoryLine {
    private static final String SEPARATOR = " | ";
    private static final String CURRENCY = "€";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/YYYY");

    protected final Amount amount;
    protected final LocalDate date;
    protected final Amount currentBalance;

    public HistoryLine(Amount amount, LocalDate date, Amount currentBalance) {
        this.amount = amount;
        this.date = date;
        this.currentBalance = currentBalance;
    }

    public void print(Printer printer) {
        String lineRepresentation = printOperationType()
                + SEPARATOR + FORMATTER.format(date)
                + SEPARATOR + amount.print() + CURRENCY
                + SEPARATOR + currentBalance.print() + CURRENCY;

        printer.print(lineRepresentation);
    }

    protected abstract String printOperationType();

    public abstract Amount combineAmounts(Amount amount);
}
