package com.bankaccount.infra.controller;

import com.bankaccount.domain.Account;
import com.bankaccount.domain.history.HistoryPrinter;
import com.bankaccount.domain.money.Amount;
import com.bankaccount.domain.operations.Operation;
import com.bankaccount.infra.repository.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@RequestMapping
public class Controller {
    private static final Logger log = LoggerFactory.getLogger(Controller.class);
    public static final String HISTORY_PATH = "/history/{version}";
    private final Repository repository;
    private final Supplier<LocalDate> dateSupplier;

    public Controller(Repository repository, Supplier<LocalDate> dateSupplier) {
        this.repository = repository;
        this.dateSupplier = dateSupplier;
    }

    @GetMapping(path = "/versions")
    public ResponseEntity<Versions> versions() {
        log.info("Accessing list of all versions");
        final List<Operation> operations = repository.operations();
        if (!operations.isEmpty()) {
            return ResponseEntity.ok(new Versions(operations.size()));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(path = HISTORY_PATH)
    public ResponseEntity<List<HistoryLine>> history(@PathVariable("version") int version) {
        log.info("Accessing history {}", version);
        final Account account = getAccount(version);
        final ArrayList<HistoryLine> lines = new ArrayList<>();
        final HistoryPrinter historyPrinter = new HistoryPrinter((operationType, operationDate, amount, balance) -> lines.add(new HistoryLine(operationType, operationDate, amount, balance)));

        account.readAccount(historyPrinter);

        return ResponseEntity.ok()
                .cacheControl(CacheControl.maxAge(Duration.ofDays(365)))
                .body(lines);
    }

    @GetMapping(path = "/deposit/{amount}")
    public ResponseEntity<?> deposit(@PathVariable("amount") long amount) {
        log.info("Depositing {}", amount);
        final Account account = getAccount();

        final Operation operation = account.deposit(Amount.of(amount));
        repository.add(operation);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/withdraw/{amount}")
    public ResponseEntity<?> withdraw(@PathVariable("amount") long amount) {
        log.info("Withdrawing {}", amount);
        final Account account = getAccount();

        final Operation operation = account.withdraw(Amount.of(amount));
        repository.add(operation);
        return ResponseEntity.noContent().build();
    }

    private Account getAccount() {
        final int lastVersion = repository.operations().size();
        return getAccount(lastVersion);
    }

    private Account getAccount(int version) {
        final Operation[] operations = repository.operations()
                .stream()
                .limit(version)
                .toArray(Operation[]::new);
        return new Account(dateSupplier, operations);
    }
}
