package com.bankaccount.infra;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

class VersionsTest {
    @Test
    void should_serialize_properly() throws IOException, URISyntaxException, JSONException {
        final String json = new ObjectMapper().writeValueAsString(new Versions(0));

        final String expected = Files.lines(Paths.get(getClass().getResource("/versions/simple-version.json").toURI())).collect(Collectors.joining());
        JSONAssert.assertEquals(json, expected, true);
    }
}