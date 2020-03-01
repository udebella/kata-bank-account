package com.bankaccount.infra.controller;

import com.bankaccount.domain.money.Amount;
import com.bankaccount.domain.operations.Deposit;
import com.bankaccount.domain.operations.Operation;
import com.bankaccount.domain.operations.Withdrawal;
import com.bankaccount.infra.repository.Repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class ControllerTest {

    private Controller controller;
    private Repository repository;

    @BeforeEach
    void setUp() {
        repository = mock(Repository.class);
        controller = new Controller(repository);
    }

    @Test
    void should_return_no_versions_when_repository_is_empty() {
        doReturn(Collections.emptyList()).when(repository).operations();

        final ResponseEntity<?> response = controller.versions();

        assertThat(response).isEqualTo(ResponseEntity.notFound().build());
    }

    @Test
    void should_return_list_of_versions() {
        doReturn(Collections.singletonList(mock(Operation.class))).when(repository).operations();

        final ResponseEntity<?> response = controller.versions();

        assertThat(response).isEqualTo(ResponseEntity.ok(new Versions(1)));
    }

    @Test
    void should_return_history() {
        final LocalDate operationDate = LocalDate.of(2020, Month.MARCH, 1);
        doReturn(Collections.singletonList(new Deposit(Amount.of(10), operationDate))).when(repository).operations();

        final ResponseEntity<?> response = controller.history(0L);

        assertThat(response).isEqualTo(ResponseEntity.ok(Collections.singletonList(new HistoryLine("Deposit", operationDate, 10, 10))));
    }

    @Test
    void should_return_part_of_history() {
        final LocalDate operationDate = LocalDate.of(2020, Month.MARCH, 1);
        doReturn(Arrays.asList(new Deposit(Amount.of(10), operationDate), new Withdrawal(Amount.of(10), operationDate))).when(repository).operations();

        final ResponseEntity<?> response = controller.history(0L);

        assertThat(response).isEqualTo(ResponseEntity.ok(Collections.singletonList(new HistoryLine("Deposit", operationDate, 10, 10))));
    }
}
