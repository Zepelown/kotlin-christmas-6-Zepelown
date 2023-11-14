import christmas.model.MenuCategory
import christmas.model.MenuType

class OrderItem(
    private val menuName: String?,
    private val amount: Int?
) : Comparable<OrderItem> {
    init {
        require(isParametersNotNull())
        require(isAmountVariableInRange())
        require(isVariableMenu())
    }

    fun getAmount(): Int = amount!!

    fun getMenuName(): String = menuName!!

    fun calculateCost(): Int = MenuType.getMenuCost(menuName!!) * amount!!

    fun getMenuCategory(): MenuCategory = calculateMenuCategory()

    fun isBeverage(): Boolean = if (calculateMenuCategory() is MenuType.Beverage) true else false

    private fun isParametersNotNull() = menuName != null && amount != null

    private fun isAmountVariableInRange() = amount in 1..20

    private fun isVariableMenu() = menuName?.let { MenuType.isMenuExists(it) } ?: false

    private fun calculateMenuCategory(): MenuCategory = MenuType.getMenuCategory(menuName!!)
    override fun compareTo(other: OrderItem): Int =
        when {
            this.menuName == other.menuName -> 0
            else -> 1
        }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as OrderItem

        return menuName == other.menuName
    }

    override fun hashCode(): Int {
        return menuName?.hashCode() ?: 0
    }
}
