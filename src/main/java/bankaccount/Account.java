package bankaccount;

import bankaccount.history.DepositLine;
import bankaccount.history.HistoryLine;
import bankaccount.history.WithdrawLine;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private final List<HistoryLine> history = new ArrayList<>();
    private final DateService dateService;

    public Account(DateService dateService) {
        this.dateService = dateService;
    }

    public void deposit(Amount amount) {
        verifyPositiveAmount(amount);
        history.add(DepositLine.of(amount, dateService.now(), balance().add(amount)));
    }

    public void withdraw(Amount amount) {
        verifyPositiveAmount(amount);
        history.add(WithdrawLine.of(amount, dateService.now(), balance().add(amount.negative())));
    }

    private void verifyPositiveAmount(Amount amount) {
        if (amount.isNegative()) {
            throw new IllegalArgumentException("Negative amounts are not allowed");
        }
    }

    public List<HistoryLine> history(Printer printer) {
        printer.print("OPERATION | DATE | AMOUNT | BALANCE");
        history.forEach(historyLine -> historyLine.print(printer));
        return history;
    }

    public Amount balance() {
        return history.stream()
                .reduce(Amount.ZERO, (amount, line) -> line.combineAmounts(amount), Amount::add);
    }
}
