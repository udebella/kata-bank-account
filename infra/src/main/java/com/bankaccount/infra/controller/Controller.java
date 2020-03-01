package com.bankaccount.infra.controller;

import com.bankaccount.domain.Account;
import com.bankaccount.domain.history.HistoryPrinter;
import com.bankaccount.domain.money.Amount;
import com.bankaccount.domain.operations.Operation;
import com.bankaccount.infra.repository.Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@RequestMapping
public class Controller {
    private final Repository repository;

    public Controller(Repository repository) {
        this.repository = repository;
    }

    @GetMapping(path = "/versions")
    public ResponseEntity<Versions> versions() {
        final List<Operation> operations = repository.operations();
        if (!operations.isEmpty()) {
            return ResponseEntity.ok(new Versions(operations.size()));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(path = "/history/{version}")
    public ResponseEntity<List<HistoryLine>> history(@PathVariable("version") int version) {
        final Account account = getAccount(version);
        final ArrayList<HistoryLine> lines = new ArrayList<>();
        final HistoryPrinter historyPrinter = new HistoryPrinter((operationType, operationDate, amount, balance) -> lines.add(new HistoryLine(operationType, operationDate, amount, balance)));

        account.readAccount(historyPrinter);

        return ResponseEntity.ok()
                .body(lines);
    }

    @GetMapping(path = "/deposit/{amount}")
    public ResponseEntity<?> deposit(@PathVariable("amount") long amount) {
        final Account account = getAccount();

        final Operation operation = account.deposit(Amount.of(amount));
        repository.add(operation);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/withdraw/{amount}")
    public ResponseEntity<?> withdraw(@PathVariable("amount") long amount) {
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
        return new Account(operations);
    }
}
