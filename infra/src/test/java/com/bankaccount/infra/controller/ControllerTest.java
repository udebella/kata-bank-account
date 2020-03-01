package com.bankaccount.infra.controller;

import com.bankaccount.domain.money.Amount;
import com.bankaccount.domain.operations.Deposit;
import com.bankaccount.domain.operations.Operation;
import com.bankaccount.domain.operations.Withdrawal;
import com.bankaccount.infra.repository.Repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

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

        final ResponseEntity<?> response = controller.history(1);

        final List<HistoryLine> history = Collections.singletonList(new HistoryLine("Deposit", operationDate, 10, 10));
        final ResponseEntity<List<HistoryLine>> expectedResponse = ResponseEntity.ok()
                .cacheControl(CacheControl.maxAge(Duration.ofDays(365)))
                .body(history);
        assertThat(response).isEqualTo(expectedResponse);
    }

    @Test
    void should_return_part_of_history() {
        final LocalDate operationDate = LocalDate.of(2020, Month.MARCH, 1);
        doReturn(Arrays.asList(new Deposit(Amount.of(10), operationDate), new Withdrawal(Amount.of(10), operationDate))).when(repository).operations();

        final ResponseEntity<?> response = controller.history(1);

        final List<HistoryLine> history = Collections.singletonList(new HistoryLine("Deposit", operationDate, 10, 10));
        final ResponseEntity<List<HistoryLine>> expectedResponse = ResponseEntity.ok()
                .cacheControl(CacheControl.maxAge(Duration.ofDays(365)))
                .body(history);
        assertThat(response).isEqualTo(expectedResponse);
    }

    @Test
    void should_allow_deposits() {
        doReturn(Collections.emptyList()).when(repository).operations();

        final ResponseEntity<?> response = controller.deposit(100L);

        verify(repository).add(new Deposit(Amount.of(100L), LocalDate.of(2020, Month.MARCH, 1)));
        assertThat(response).isEqualTo(ResponseEntity.noContent().build());
    }

    @Test
    void should_allow_withdrawal() {
        doReturn(Collections.emptyList()).when(repository).operations();

        final ResponseEntity<?> response = controller.withdraw(100L);

        verify(repository).add(new Withdrawal(Amount.of(100L), LocalDate.of(2020, Month.MARCH, 1)));
        assertThat(response).isEqualTo(ResponseEntity.noContent().build());
    }
}
