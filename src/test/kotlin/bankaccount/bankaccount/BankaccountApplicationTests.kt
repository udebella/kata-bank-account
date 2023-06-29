package bankaccount.bankaccount

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


@SpringBootTest
@AutoConfigureMockMvc
class BankaccountApplicationTests {

	@Autowired
	private lateinit var mvc: MockMvc

	@Test
	fun `prints empty history for an empty account`() {
		mvc.perform(get("/account/history"))
			.andExpect(status().`is`(200))
			.andExpect(content().string("OPERATION | DATE | AMOUNT | BALANCE"))
	}

}
