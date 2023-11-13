package christmas.model

class Order(private val order: List<OrderItem>) {

    init {
        require(!hasDuplicateMenu())
    }

    private fun hasDuplicateMenu(): Boolean = order.size != order.toSet().size

    //TODO
    private fun hasOnlyDrinkMenu()  {

    }


}