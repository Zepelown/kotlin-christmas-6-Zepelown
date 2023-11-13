package christmas.util

import christmas.util.InputParser
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputParserTest {

    @ParameterizedTest
    @ValueSource(strings = ["양송이수프-1,아이스크림-2", "해산물파스타-2,레드와인-1,초코케이크-1","해산물파스타-2,제로콜라-18"])
    fun `정상적인 값 입력`(input: String) {
        assertDoesNotThrow { InputParser.parseOrder(input) }
    }


    @ParameterizedTest
    @ValueSource(strings = [" ", "asdfasdf", "asdfqwer_123", "123", "`"])
    fun `형식에 맞지 않는 메뉴 입력`(input: String) {
        assertThrows<IllegalArgumentException> { InputParser.parseOrder(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["타파스-1,타파스-2", "아이스크림-1,아이스크림-2","타파스-1,양송이수프-2,타파스-3"])
    fun `메뉴 중복 입력`(input: String) {
        assertThrows<IllegalArgumentException> { InputParser.parseOrder(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["제로콜라-1","제로콜라-2,레드와인-3"])
    fun `음료수만 입력`(input: String) {
        assertThrows<IllegalArgumentException> { InputParser.parseOrder(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["타파스-21","타파스-1,레드와인-20","아이스크림-3,양송이수프-10,바비큐립-10"])
    fun `메뉴 개수가 20개가 넘을 때`(input: String){
        assertThrows<IllegalArgumentException> { InputParser.parseOrder(input) }
    }

}