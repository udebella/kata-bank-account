package bankaccount;

import bankaccount.Amount.AmountBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AmountTest {
    private AmountBuilder amountBuilder;

    @Before
    public void setUp() {
        amountBuilder = new AmountBuilder();
    }

    @Test(expected = IllegalStateException.class)
    public void should_not_allow_negative_amounts() {
        amountBuilder
                .withValueAsCents(-1)
                .build();
    }

    @Test
    public void same_amounts_should_be_equal() {
        assertThat(amountBuilder.withValueAsCents(100).build())
                .isEqualTo(amountBuilder.withValueAsCents(100).build());
    }

    @Test
    public void should_allow_to_add_amounts() {
        final Amount amount = amountBuilder.withValueAsCents(100).build();

        final Amount addition = amount.add(amountBuilder.withValueAsCents(50).build());

        assertThat(addition)
                .isEqualTo(amountBuilder.withValueAsCents(150).build());
    }
}
