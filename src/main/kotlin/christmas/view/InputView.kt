package christmas.view

import camp.nextstep.edu.missionutils.Console
import christmas.model.Date
import christmas.util.Validator

class InputView {
    fun readDate() : Int{
        val input = Console.readLine().toIntOrNull()
        if (!Validator.validateDate(input)){
            println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.")
            return readDate()
        }
        return input!!
    }
}