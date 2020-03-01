package com.bankaccount.infra.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.util.stream.Collectors;

class HistoryLineTest {
    @Test
    void should_serialize_properly() throws IOException, URISyntaxException, JSONException {
        final String json = new ObjectMapper().writeValueAsString(new HistoryLine("Deposit", LocalDate.of(2020, Month.MARCH, 1), 10, 10));

        final String expected = Files.lines(Paths.get(getClass().getResource("/history/history-line.json").toURI())).collect(Collectors.joining());
        JSONAssert.assertEquals(expected, json, true);
    }
}