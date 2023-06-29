package bankaccount.bankaccount

import bankaccount.Account
import bankaccount.Amount
import org.springframework.web.bind.annotation.*
import java.time.LocalDate

@RestController
@RequestMapping("/account")
class AccountRestController {

    private val account: Account = Account { LocalDate.now() }

    @GetMapping("/history")
    private fun history(): String {
        val result = StringBuilder()
        account.history { message: String? ->
            if (result.toString().length != 0) {
                result.append("\n")
            }
            result.append(message)
        }
        return result.toString()
    }

    @PostMapping("/deposit")
    private fun deposit(@RequestBody amount: AmountDto) {
        account.deposit(Amount.of(amount.amount))
    }
}

class AmountDto (val amount: Int)
