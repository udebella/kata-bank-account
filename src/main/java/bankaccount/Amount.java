package bankaccount;

public class Amount {
    private final int valueAsCents;

    private Amount(int valueAsCents) {
        this.valueAsCents = valueAsCents;
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
