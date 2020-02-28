package com.bankaccount.infra;

import java.util.Collections;
import java.util.List;

public class Versions {
    private final List<String> versions;

    public Versions(int maxVersionNumber) {
        this.versions = Collections.singletonList("/0");
    }

    public List<String> getVersions() {
        return versions;
    }
}
