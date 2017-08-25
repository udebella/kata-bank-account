package bankaccount;

public class Amount {
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
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        return new Amount(amount);
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
