package christmas.model

class OrderItem(
    private val menuName: String?,
    private val amount: Int?
) {
    init {
        require(isParametersNotNull())
        require(isAmountVariableInRange())
        require(isVariableMenu())
    }

    private fun isParametersNotNull() = if(menuName != null && amount != null) true else false

    private fun isAmountVariableInRange() = if(amount !! >= 1 && amount <= 20) true else false

    private fun isVariableMenu() = MenuType.isMenuExists(menuName!!)

}