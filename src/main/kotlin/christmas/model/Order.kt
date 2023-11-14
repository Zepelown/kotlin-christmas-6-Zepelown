package christmas.model

import OrderItem

class Order(private val order: List<OrderItem>) {
    init {
        require(!hasDuplicateMenu())
        require(!hasOnlyBeverageMenu())
        require(!isOverMaxItemCount())
    }

    fun getOrder() : List<OrderItem> = order
    private fun hasDuplicateMenu(): Boolean = order.size != order.toSet().size
    private fun hasOnlyBeverageMenu() : Boolean {
        order.forEach {
            if(!it.isBeverage())
                return false
        }
        return true
    }
    private fun isOverMaxItemCount() : Boolean {
        var count = 0
        order.forEach {
            count += it.getAmount()
        }
        return count > 20
    }


}