package christmas.model

import OrderItem

class Order(private val order: List<OrderItem>) {
    private var appetizerTotalCost: Int = 0
    private var mainDishTotalCost: Int = 0
    private var dessertTotalCost: Int = 0
    private var beverageTotalCost: Int = 0

    init {
        require(!hasDuplicateMenu())
        require(!hasOnlyBeverageMenu())
        require(!isOverMaxItemCount())
        calculateCost()
    }

    fun getOrderItems(): List<OrderItem> = order

    fun getTotalCost(): Int = appetizerTotalCost + mainDishTotalCost + dessertTotalCost + beverageTotalCost

    private fun hasDuplicateMenu(): Boolean = order.size != order.toSet().size
    private fun hasOnlyBeverageMenu(): Boolean {
        order.forEach {
            if (!it.isBeverage())
                return false
        }
        return true
    }

    private fun isOverMaxItemCount(): Boolean {
        var count = 0
        order.forEach {
            count += it.getAmount()
        }
        return count > 20
    }

    private fun calculateCost() {
        order.forEach {
            when(it.getMenuCategory()){
                is MenuType.Beverage ->beverageTotalCost += it.calculateCost()
                is MenuType.Dessert -> dessertTotalCost += it.calculateCost()
                is MenuType.MainDish -> mainDishTotalCost += it.calculateCost()
                is MenuType.Appetizer -> appetizerTotalCost += it.calculateCost()
                else -> {}
            }
        }
    }


}