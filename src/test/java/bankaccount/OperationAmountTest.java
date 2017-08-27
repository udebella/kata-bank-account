package bankaccount;

import org.junit.Test;

public class OperationAmountTest {
    @Test(expected = IllegalArgumentException.class)
    public void amount_should_not_be_negative() {
        OperationAmount.of(-10);
    }
}
