package com.bankaccount.domain;

public interface Amount {
    Balance add(PositiveAmount other);
}
