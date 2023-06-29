package bankaccount.bankaccount

import bankaccount.Account
import org.springframework.web.bind.annotation.*
import java.time.LocalDate

@RestController
@RequestMapping("/account")
class AccountRestController {

    @GetMapping("/history")
    private fun history(): String {
        val account = Account { LocalDate.now() }
        val result = StringBuilder()
        account.history { message: String? -> result.append(message) }
        return result.toString()
    }
}