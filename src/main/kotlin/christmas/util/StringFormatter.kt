package christmas.util

import java.text.NumberFormat
import java.util.*

object StringFormatter {
    //110000 -> 110,000원으로 포맷 변경 
    fun parseToCost(input : Int) = NumberFormat.getNumberInstance(Locale.KOREA).format(input) + "원"
    //110000 -> -110,000원으로 포맷 변경
    fun parseToBenefitCost(input : Int) = "-" + NumberFormat.getNumberInstance(Locale.KOREA).format(input) + "원"
}