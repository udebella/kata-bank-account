package bankaccount.bankaccount

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

class Amount private constructor(public val value: Int) {
    fun add(amountToAdd: Amount): Amount {
        return of(amountToAdd.value + value)
    }

    fun negative(): Amount {
        return of(-value)
    }

    val isNegative: Boolean
        get() = value < 0

    fun print(): String {
        val decimalFormat = DecimalFormat("#.##", DecimalFormatSymbols.getInstance(Locale.FRANCE))
        val result = StringBuilder()
        if (value > 0) {
            result.append("+")
        }
        result.append(decimalFormat.format(value / 100.0))
        result.append(CURRENCY)
        return result.toString()
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val amount = o as Amount
        return value == amount.value
    }

    override fun hashCode(): Int {
        return value
    }

    override fun toString(): String {
        return "Amount{" +
                "value=" + value +
                '}'
    }

    companion object {
        val ZERO = of(0)
        private const val CURRENCY = "€"
        fun of(amount: Int): Amount {
            return Amount(amount)
        }
    }
}
