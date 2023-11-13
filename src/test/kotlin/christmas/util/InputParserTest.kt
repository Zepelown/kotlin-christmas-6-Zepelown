package christmas.util

import christmas.util.InputParser
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputParserTest {

    @ParameterizedTest
    @ValueSource(strings = ["양송이수프-1,아이스크림-2","해산물파스타-2,레드와인-1,초코케이크-1"])
    fun `정상적인 값 입력`(input : String) {
        assertDoesNotThrow { InputParser.parseOrder(input)  }
    }


    @ParameterizedTest
    @ValueSource(strings= [" ","asdfasdf","asdfqwer_123", "123", "`"])
    fun `형식에 맞지 않는 메뉴 입력`(input: String){
        assertThrows<IllegalArgumentException> { InputParser.parseOrder(input) }
    }



}