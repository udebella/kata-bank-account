package bankaccount.bankaccount

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.time.LocalDate

@RestController
@RequestMapping("/account")
class AccountRestController {

    private val account: Account = Account { LocalDate.now() }


    @GetMapping("/history")
    private fun history(): List<HistoryDTO> {
        return account.history().map { HistoryDTO(it.printOperationType(), it.date, it.amount.value, it.currentBalance.value) }
    }

    @PostMapping("/deposit")
    private fun deposit(@RequestBody amount: AmountDto) {
        account.deposit(Amount.of(amount.amount))
    }
}

class AmountDto (val amount: Int)
class HistoryDTO (val operation: String, val date: LocalDate, val amount: Int, val balance: Int)
