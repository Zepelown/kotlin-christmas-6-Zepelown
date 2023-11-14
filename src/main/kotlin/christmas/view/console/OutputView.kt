package christmas.view.console

import OrderItem
import christmas.model.Date
import christmas.model.Order

class OutputView {
    fun printStartMessage(){
        println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.")
    }

    fun printDateInputMessage(){
        println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)")
    }

    fun printOrderInputMessage(){
        println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)")
    }

    fun printEventBenefitsTitleMessage(date:Date){
        println("12월 ${date.getDate()}일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!")
    }

    fun printOrder(order: Order){
        println("<주문 메뉴>")
        order.getOrder().forEach{
            printOrderItem(it)
        }
    }

    private fun printOrderItem(orderItem : OrderItem){
        println("${orderItem.getMenuName()} ${orderItem.getAmount()}개")
    }
}