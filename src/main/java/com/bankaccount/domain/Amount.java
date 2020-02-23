package com.bankaccount.domain;

public interface Amount {
    Balance add(PositiveAmount other);

    Balance subtract(PositiveAmount amount);
}
