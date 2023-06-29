package bankaccount.bankaccount

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import java.time.LocalDate
import java.time.Month
import java.time.format.DateTimeFormatter

class AccountTest {
    private lateinit var account: Account
    private lateinit var dateService: DateService
    @BeforeEach
    fun setUp() {
        dateService = Mockito.mock(DateService::class.java)
        account = Account(dateService)

        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
        val date = LocalDate.parse("29-06-2023", formatter)

        Mockito.`when`(dateService.now()).thenReturn(date)
    }

    @Test
    fun balance_should_be_zero_by_default() {
        Assertions.assertThat(account.balance()).isEqualTo(Amount.ZERO)
    }

    @Test
    fun deposit_should_not_allow_negative_amounts() {
        Assertions.assertThatThrownBy { account.deposit(Amount.of(-10)) }.isInstanceOf(
            IllegalArgumentException::class.java
        )
    }

    @Test
    fun deposit_should_update_account_balance() {
        account.deposit(Amount.of(10))
        Assertions.assertThat(account.balance()).isEqualTo(Amount.of(10))
    }

    @Test
    fun multiple_deposit_should_update_account_balance() {
        account.deposit(Amount.of(10))
        account.deposit(Amount.of(10))
        Assertions.assertThat(account.balance()).isEqualTo(Amount.of(20))
    }

    @Test
    fun multiple_deposit_of_different_amount_should_update_balance() {
        account.deposit(Amount.of(10))
        account.deposit(Amount.of(15))
        Assertions.assertThat(account.balance()).isEqualTo(Amount.of(25))
    }

    @Test
    fun withdraw_nothing_should_not_update_balance() {
        account.withdraw(Amount.ZERO)
        Assertions.assertThat(account.balance()).isEqualTo(Amount.ZERO)
    }

    @Test
    fun withdraw_should_not_allow_negative_amounts() {
        Assertions.assertThatThrownBy { account.withdraw(Amount.of(-10)) }.isInstanceOf(
            IllegalArgumentException::class.java
        )
    }

    @Test
    fun withdraw_should_update_account_balance() {
        account.withdraw(Amount.of(50))
        Assertions.assertThat(account.balance()).isEqualTo(Amount.of(-50))
    }

    @Test
    fun multiple_withdraw_should_update_account_balance() {
        account.withdraw(Amount.of(50))
        account.withdraw(Amount.of(50))
        Assertions.assertThat(account.balance()).isEqualTo(Amount.of(-100))
    }

    @Test
    fun history_should_return_an_empty_list_when_empty() {
        val history = account.history()
        Assertions.assertThat(history).isEmpty()
    }

    @Test
    fun history_should_keep_track_of_deposits() {
        val today = LocalDate.of(2017, Month.AUGUST, 27)
        Mockito.`when`(dateService.now())
            .thenReturn(today)
        account.deposit(Amount.of(1000))

        val history = account.history()

        val expectedLine = DepositLine.of(
            Amount.of(1000), today, Amount.of(1000)
        )
        Assertions.assertThat(history).containsExactly(expectedLine)
    }

    @Test
    fun history_should_keep_track_of_withdrawals() {
        Mockito.`when`(dateService.now())
            .thenReturn(LocalDate.of(2017, Month.AUGUST, 27))
        account.withdraw(Amount.of(1000))

        val history = account.history()

        val expectedLine = WithdrawLine.of(Amount.of(1000), LocalDate.of(2017, Month.AUGUST, 27), Amount.of(1000))
        Assertions.assertThat(history).containsExactly(expectedLine)
    }
}
