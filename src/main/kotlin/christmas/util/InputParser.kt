package christmas.util

import christmas.model.Order
import christmas.model.OrderItem

object InputParser {
    fun parseOrder(order: List<String>): Order {
        val orderItems = ArrayList<OrderItem>()
        order.forEach {
            val orderItem = parseOrderItem(it)
            println(orderItem)
            orderItems.add(orderItem)
        }
        return Order(orderItems)
    }

    fun parseOrderItem(orderItem : String) : OrderItem{
        val menuInput = orderItem.split("-")
        if (menuInput.size != 2){
            println("size != 2")
            throw IllegalArgumentException()
        }
        val menuName = menuInput[0]
        val menuAmount = menuInput[1]
        println("${menuName},${menuAmount}")
        return OrderItem(menuName, menuAmount.toIntOrNull())
    }

}