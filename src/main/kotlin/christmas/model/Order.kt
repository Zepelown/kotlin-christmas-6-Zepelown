package christmas.model

class Order(private val order: List<OrderItem>) {

    init {
        require(!hasDuplicateMenu())
        require(!hasOnlyBeverageMenu())
    }

    private fun hasDuplicateMenu(): Boolean = order.size != order.toSet().size
    private fun hasOnlyBeverageMenu() : Boolean {
        order.forEach {
            if(!it.isBeverage())
                return false
        }
        return true
    }


}