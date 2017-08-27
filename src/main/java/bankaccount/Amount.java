package bankaccount;

import java.text.DecimalFormat;

public class Amount {
    public static final Amount ZERO = Amount.of(0);
    private final int value;

    private Amount(int value) {
        this.value = value;
    }

    public static Amount of(int amount) {
        return new Amount(amount);
    }

    public Amount add(Amount amountToAdd) {
        return Amount.of(amountToAdd.value + value);
    }

    public Amount negative() {
        return Amount.of(-value);
    }

    public boolean isNegative() {
        return value < 0;
    }

    public String print() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        StringBuilder result = new StringBuilder();
        if (value > 0) {
            result.append("+");
        }
        result.append(decimalFormat.format(value / 100d));
        return result.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Amount amount = (Amount) o;

        return value == amount.value;
    }

    @Override
    public int hashCode() {
        return value;
    }

    @Override
    public String toString() {
        return "Amount{" +
                "value=" + value +
                '}';
    }
}
