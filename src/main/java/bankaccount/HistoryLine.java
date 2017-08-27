package bankaccount;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HistoryLine {
    private static final String SEPARATOR = " | ";
    private static final String CURRENCY = "€";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/YYYY");

    private final OperationType operationType;
    private final Amount amount;
    private final LocalDate date;
    private final Amount currentBalance;

    private HistoryLine(OperationType operationType, Amount amount, LocalDate date, Amount currentBalance) {
        this.operationType = operationType;
        this.amount = amount;
        this.date = date;
        this.currentBalance = currentBalance;
    }

    public static HistoryLine of(OperationType deposit, Amount amount, LocalDate operationDate, Amount balance) {
        return new HistoryLine(deposit, amount, operationDate, balance);
    }

    public void print(Printer printer) {
        String lineRepresentation = operationType.toString()
                + SEPARATOR + FORMATTER.format(date)
                + SEPARATOR + amount.print() + CURRENCY
                + SEPARATOR + currentBalance.print() + CURRENCY;

        printer.print(lineRepresentation);
    }

    public Amount getAmount() {
        if (operationType == OperationType.WITHDRAW) {
            return amount.negative();
        }
        return amount;
    }
}
