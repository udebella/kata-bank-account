package com.bankaccount.infra;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Versions {
    private final List<String> versions;

    public Versions(int maxVersionNumber) {
        this.versions = IntStream.rangeClosed(0, maxVersionNumber)
                .mapToObj(version -> "/" + version)
                .collect(Collectors.toList());
    }

    public List<String> getVersions() {
        return versions;
    }
}
