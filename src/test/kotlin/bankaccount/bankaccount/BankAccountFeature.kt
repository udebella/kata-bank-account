package bankaccount.bankaccount

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import java.time.LocalDate
import java.time.Month

class BankAccountFeature {
    private lateinit var dateService: DateService
    @BeforeEach
    fun setUp() {
        dateService = Mockito.mock(DateService::class.java)
    }

    @Test
    fun deposit_and_withdrawal_on_accounts() {
        Mockito.`when`(dateService.now())
            .thenReturn(
                LocalDate.of(2017, Month.AUGUST, 25),
                LocalDate.of(2017, Month.AUGUST, 26),
                LocalDate.of(2017, Month.AUGUST, 30)
            )
        val account = Account(dateService)

        account.deposit(Amount.of(1000))
        account.withdraw(Amount.of(500))
        account.deposit(Amount.of(5000))
        val history = account.history()

        Assertions.assertThat(history)
            .containsExactly(
                DepositLine.of(Amount.of(1000), LocalDate.of(2017, Month.AUGUST, 25), Amount.of(1000)),
                WithdrawLine.of(Amount.of(500), LocalDate.of(2017, Month.AUGUST, 26), Amount.of(500)),
                DepositLine.of(Amount.of(5000), LocalDate.of(2017, Month.AUGUST, 30), Amount.of(5500)),
                )
    }
}
