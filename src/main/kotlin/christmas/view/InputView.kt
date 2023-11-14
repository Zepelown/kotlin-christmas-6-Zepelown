package christmas.view

import camp.nextstep.edu.missionutils.Console
import christmas.model.Date
import christmas.model.Order
import christmas.util.InputParser

class InputView {
    fun readDate() : Date {
        val date : Date
        val input = Console.readLine()
        try {
            date = InputParser.parseDate(input)
        } catch (e : IllegalArgumentException){
            println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.")
            return readDate()
        }
        return date!!
    }

    fun readOrder() : Order{
        val order : Order
        val input = Console.readLine()
        try{
            order = InputParser.parseOrder(input)
        } catch (e : IllegalArgumentException){
            println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.")
            return readOrder()
        }
        return order!!
    }
}