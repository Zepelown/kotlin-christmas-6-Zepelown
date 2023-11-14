package christmas.model

import OrderItem

class Order(private val order: List<OrderItem>) {
    private var totalCost : Int = 0
    init {
        require(!hasDuplicateMenu())
        require(!hasOnlyBeverageMenu())
        require(!isOverMaxItemCount())

        totalCost = calculateTotalCost()
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

    private fun calculateTotalCost() : Int {
        var cost = 0
        order.forEach{
            cost += it.getMenuCost()
        }
        return cost
    }


}