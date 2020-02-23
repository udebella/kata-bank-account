package com.bankaccount.domain.money;

public interface Amount {
    Balance add(PositiveAmount other);

    Balance subtract(PositiveAmount amount);
}
