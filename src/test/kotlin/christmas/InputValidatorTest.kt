package christmas

import christmas.util.InputValidator
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputValidatorTest {
    @ParameterizedTest
    @ValueSource(ints = [-1,100,0])
    fun `1 ~ 31 범위에 벗어나는 입력 시`(input : Int){
        assertFalse { InputValidator.validateDate(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["`","asdf","12c"])
    fun `숫자가 아닌 값 입력 시`(input : String){
        assertFalse {InputValidator.validateDate(input.toIntOrNull())}
    }
}