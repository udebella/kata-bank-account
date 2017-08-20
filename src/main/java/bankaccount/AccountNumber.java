package bankaccount;

public class AccountNumber {
    private final int number;

    private AccountNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountNumber that = (AccountNumber) o;

        return number == that.number;
    }

    @Override
    public int hashCode() {
        return number;
    }

    public static class AccountNumberBuilder {
        private int number;

        public AccountNumberBuilder withNumber(int number) {
            this.number = number;
            return this;
        }

        public AccountNumber build() {
            return new AccountNumber(this.number);
        }
    }
}
