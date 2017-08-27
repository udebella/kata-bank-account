package bankaccount;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HistoryLine {
    private final OperationType deposit;
    private final Amount amount;
    private final LocalDate date;
    private final Amount currentBalance;

    private HistoryLine(OperationType deposit, Amount amount, LocalDate date, Amount currentBalance) {
        this.deposit = deposit;
        this.amount = amount;
        this.date = date;
        this.currentBalance = currentBalance;
    }

    public static HistoryLine of(OperationType deposit, Amount amount, LocalDate operationDate, Amount balance) {
        return new HistoryLine(deposit, amount, operationDate, balance);
    }

    public void print(Printer printer) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        String lineRepresentation = deposit.toString() + " | " + dateFormat.format(date) + " | " + amount.print() + "€ | " + currentBalance.print() + "€";

        printer.print(lineRepresentation);
    }
}
