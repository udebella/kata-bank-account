package bankaccount;

public class Amount {
    private final int valueAsCents;

    private Amount(int valueAsCents) {
        this.valueAsCents = valueAsCents;
    }

    public Amount add(Amount amountToAdd) {
        return Amount.fromValue(amountToAdd.valueAsCents + valueAsCents);
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

    public static Amount fromValue(int valueAsCents) {
        if (valueAsCents < 0) {
            throw new IllegalStateException("Amounts should be positive values");
        }
        return new Amount(valueAsCents);
    }
}
