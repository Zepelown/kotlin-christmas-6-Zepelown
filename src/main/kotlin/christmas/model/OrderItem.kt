import christmas.model.MenuType

class OrderItem(
    private val menuName: String?,
    private val amount: Int?
) : Comparable<OrderItem> {
    private var menuCategory: String? = null

    init {
        require(isParametersNotNull())
        require(isAmountVariableInRange())
        require(isVariableMenu())

        menuCategory = calculateMenuCategory()
    }

    override fun compareTo(other: OrderItem): Int =
        when {
            this.menuCategory == other.menuCategory -> 0
            else -> 1
        }

    fun isBeverage(): Boolean = menuCategory == "Beverage"

    fun getAmount() : Int = amount!!

    fun getMenuName() : String = menuName!!

    private fun isParametersNotNull() = menuName != null && amount != null

    private fun isAmountVariableInRange() = amount in 1..20

    private fun isVariableMenu() = menuName?.let { MenuType.isMenuExists(it) } ?: false

    private fun calculateMenuCategory() = menuName?.let { MenuType.getMenuCategory(it) }

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
