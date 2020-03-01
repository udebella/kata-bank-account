package com.bankaccount.infra.controller;

import com.bankaccount.domain.money.Amount;
import com.bankaccount.domain.operations.Deposit;
import com.bankaccount.infra.Application;
import com.bankaccount.infra.repository.Repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.Collections;

import static org.mockito.Mockito.doReturn;

@WebMvcTest
@ContextConfiguration(classes = {Application.class})
@ExtendWith(SpringExtension.class)
public class ControllerIT {
    @MockBean
    private Repository repository;

    private final MockMvc mockMvc;

    public ControllerIT(@Autowired MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @BeforeEach
    void setUp() {
        doReturn(Collections.singletonList(new Deposit(Amount.of(10), LocalDate.now()))).when(repository).operations();
    }

    @Test
    void should_respond_to_version_endpoint() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/versions"))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    void should_respond_to_history_endpoint() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/history/0"))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    void should_respond_to_deposit_endpoint() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/deposit/100"))
                .andExpect(MockMvcResultMatchers.status().is(204));
    }
}
