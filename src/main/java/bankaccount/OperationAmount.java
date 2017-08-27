package bankaccount;

public class OperationAmount {
    public static OperationAmount of(int amount) {
        throw new IllegalArgumentException("Amount cannot be negative");
    }
}
