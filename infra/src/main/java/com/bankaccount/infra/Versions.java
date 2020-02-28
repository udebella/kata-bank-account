package com.bankaccount.infra;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Versions {
    private final List<String> versions;

    public Versions(int maxVersionNumber) {
        this.versions = IntStream.rangeClosed(0, maxVersionNumber)
                .mapToObj(version -> "/" + version)
                .collect(Collectors.toList());
    }

    public List<String> getVersions() {
        return versions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Versions versions1 = (Versions) o;
        return Objects.equals(versions, versions1.versions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(versions);
    }

    @Override
    public String toString() {
        return "Versions{" +
                "versions=" + versions +
                '}';
    }
}
