package christmas.util

import christmas.model.Order
import christmas.model.OrderItem

object InputParser {
    fun parseOrder(input: String): Order {
        val orderItems = ArrayList<OrderItem>()
        val parsedInput = input.split(",")
        parsedInput?.forEach {
            val orderItem = parseOrderItem(it)
            orderItems.add(orderItem)
        }
        return Order(orderItems)
    }

    private fun parseOrderItem(orderItem : String) : OrderItem{
        val menuInput = orderItem.split("-")
        if (menuInput.size != 2){
            throw IllegalArgumentException()
        }
        val menuName = menuInput[0]
        val menuAmount = menuInput[1]
        return OrderItem(menuName, menuAmount.toIntOrNull())
    }

}