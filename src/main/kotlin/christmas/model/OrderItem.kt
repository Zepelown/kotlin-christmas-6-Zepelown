class OrderItem(
    private val menuName: String?,
    private val amount: Int?
) : Comparable<OrderItem> {
    private var menuType: MenuType

    init {
        require(isParametersNotNull())
        require(isAmountVariableInRange())
        require(isVariableMenu())
        menuType = calculateMenuCategory()
    }

    fun getAmount(): Int = amount!!

    fun getMenuName(): String = menuType.menuName

    fun calculateCost(): Int = menuType.cost * amount!!

    fun isDessert(): Boolean = menuType is MenuType.Dessert

    fun isBeverage(): Boolean = menuType is MenuType.Beverage

    fun isMainDish(): Boolean = menuType is MenuType.MainDish
    private fun isParametersNotNull() = menuName != null && amount != null

    private fun isAmountVariableInRange() = amount in 1..20

    private fun isVariableMenu() = menuName?.let { MenuType.isMenuExists(it) } ?: false

    private fun calculateMenuCategory(): MenuType = MenuType.getMenuType(menuName!!)
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

    override fun hashCode(): Int = menuName?.hashCode() ?: 0
}
