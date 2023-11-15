package christmas.view.console

import OrderItem
import christmas.model.Date
import christmas.model.EventCatalog
import christmas.model.Order
import christmas.util.StringFormatter

class OutputView {
    fun printStartMessage() {
        println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.")
    }

    fun printDateInputMessage() {
        println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)")
    }

    fun printOrderInputMessage() {
        println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)")
    }

    fun printEventBenefitsTitleMessage(date: Date) {
        println("12월 ${date.getDate()}일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!")
    }

    fun printOrder(order: Order) {
        println("\n<주문 메뉴>")
        order.getOrderItems().forEach {
            printOrderItem(it)
        }
    }

    fun printTotalCost(order: Order) {
        println("\n<할인 전 총주문 금액>")
        println(StringFormatter.parseToCost(order.getTotalCost()))
    }

    fun printGiftEvent(eventCatalog: EventCatalog) {
        println("\n<증정 메뉴>")
        println(if (eventCatalog.hasGiftEvent()) "샴페인 1개" else "없음")
    }

    fun printEventBenefits(eventCatalog: EventCatalog) {
        println("\n<혜택 내역>")
        if (!eventCatalog.hasEvent()) {
            println("없음")
            return
        }
        eventCatalog.getEventCatalog().forEach { event, discountCost ->
            println("${event.displayName}: ${StringFormatter.parseToBenefitCost(discountCost)}")
        }
    }

    fun printTotalEventDiscountCost(eventCatalog: EventCatalog) {
        println("\n<총혜택 금액>")
        if (eventCatalog.getTotalEventDiscountCost() == 0) {
            println("0원")
            return
        }
        println(StringFormatter.parseToBenefitCost(eventCatalog.getTotalEventDiscountCost()))
    }

    fun printDiscountedTotalAmount(order: Order, eventCatalog: EventCatalog) {
        println("\n<할인 후 예상 결제 금액>")
        val discountedTotalAmount =
            order.getTotalCost() - eventCatalog.getTotalEventDiscountCost() + if (eventCatalog.hasGiftEvent()) 25000 else 0
        println(StringFormatter.parseToCost(discountedTotalAmount))
    }

    fun printEventBadge(eventCatalog: EventCatalog) {
        println("\n<12월 이벤트 배지>")
        println(eventCatalog.getEventBadge())
    }

    private fun printOrderItem(orderItem: OrderItem) {
        println("${orderItem.getMenuName()} ${orderItem.getAmount()}개")
    }


}