package bankaccount;

import org.junit.Test;

public class AmountTest {

    @Test(expected = IllegalStateException.class)
    public void should_not_allow_negative_amounts() {
        new Amount.AmountBuilder()
                .withValueAsCents(-1)
                .build();
    }
}
