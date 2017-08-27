package bankaccount;

public class Amount {
    public static final Amount ZERO = Amount.of(0);
    private final int value;

    private Amount(int value) {
        this.value = value;
    }

    /**
     * Build an amount
     * @param amount in cents
     *
     * @throws IllegalArgumentException if negative value is provided
     */
    public static Amount of(int amount) {
        return new Amount(amount);
    }

    public Amount add(Amount amountToAdd) {
        return Amount.of(amountToAdd.value + value);
    }

    public Amount negative() {
        return Amount.of(-value);
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
}
