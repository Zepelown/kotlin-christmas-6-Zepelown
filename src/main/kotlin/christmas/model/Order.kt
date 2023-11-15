package christmas.model

import OrderItem

class Order(private val order: List<OrderItem>) {
    private var totalDessertAmount = 0
    private var totalMainDishAmount = 0
    private var totalCost = 0

    init {
        require(!hasDuplicateMenu())
        require(!hasOnlyBeverageMenu())
        require(!isOverMaxItemCount())
        totalCost = calculateCost()
        totalDessertAmount = calculateDessertTotalAmount()
        totalMainDishAmount = calculateMainDishTotalAmount()
    }

    fun getOrderItems(): List<OrderItem> = order

    fun getTotalCost(): Int = totalCost

    fun getTotalDessertAmount() : Int = totalDessertAmount

    fun getTotalMainDishAmount() : Int = totalMainDishAmount

    private fun hasDuplicateMenu(): Boolean = order.size != order.toSet().size
    private fun hasOnlyBeverageMenu(): Boolean = order.all { it.isBeverage() }
    private fun isOverMaxItemCount(): Boolean = order.sumOf { it.getAmount() } > 20

    private fun calculateCost(): Int = order.sumOf { it.calculateCost() }
    private fun calculateDessertTotalAmount(): Int = order.filter { it.isDessert() }.sumOf { it.getAmount() }
    private fun calculateMainDishTotalAmount(): Int = order.filter { it.isMainDish() }.sumOf { it.getAmount() }

}