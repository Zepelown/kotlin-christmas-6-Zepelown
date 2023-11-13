package christmas.view

import camp.nextstep.edu.missionutils.Console
import christmas.model.Order
import christmas.util.InputParser
import christmas.util.InputValidator

class InputView {
    fun readDate() : Int{
        val input = Console.readLine().toIntOrNull()
        if (!InputValidator.validateDate(input)){
            println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.")
            return readDate()
        }
        return input!!
    }

    fun readOrder() : Order{
        val order : Order
        val input = Console.readLine().split(",")
        try{
            order = InputParser.parseOrder(input)
        } catch (e : IllegalArgumentException){
            println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.")
            return readOrder()
        }
        return order!!
    }
}