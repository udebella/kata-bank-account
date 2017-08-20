package bankaccount;

public class Amount {
    private final int valueAsCents;

    private Amount(int valueAsCents) {
        this.valueAsCents = valueAsCents;
    }

    public Amount add(Amount amountToAdd) {
        return new AmountBuilder()
                .withValueAsCents(amountToAdd.valueAsCents + valueAsCents)
                .build();
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

    public static class AmountBuilder {
        private int valueAsCents;

        public AmountBuilder withValueAsCents(int valueAsCents) {
            this.valueAsCents = valueAsCents;
            return this;
        }

        public Amount build() {
            if (valueAsCents < 0) {
                throw new IllegalStateException("Amounts should be positive values");
            }
            return new Amount(valueAsCents);
        }
    }
}
