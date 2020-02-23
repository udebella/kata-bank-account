package com.bankaccount.domain;

public interface Operation {
    Balance applyOn(Balance balance);
}
