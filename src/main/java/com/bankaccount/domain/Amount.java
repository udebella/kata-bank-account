package com.bankaccount.domain;

public class Amount {
    public static Amount ZERO = new Amount(0);

    private final int valueAsCents;

    private Amount(int valueAsCents) {
        this.valueAsCents = valueAsCents;
    }

    public static Amount fromValue(int valueAsCents) {
        return new Amount(valueAsCents);
    }

    public Amount add(Amount amountToAdd) {
        return Amount.fromValue(amountToAdd.valueAsCents + valueAsCents);
    }

    public Amount negative() {
        return new Amount(-valueAsCents);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Amount amount = (Amount) o;

        return valueAsCents == amount.valueAsCents;
    }

    @Override
    public int hashCode() {
        return valueAsCents;
    }

    @Override
    public String toString() {
        return "Amount{" +
                "valueAsCents=" + valueAsCents +
                '}';
    }

    public int getValueAsCents() {
        return valueAsCents;
    }
}
