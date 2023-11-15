sealed class MenuType {
    abstract val menuName: String
    abstract val cost: Int

    sealed class Appetizer : MenuType() {
        object MushroomSoup : Appetizer() {
            override val menuName: String = "양송이수프"
            override val cost: Int = 6000
        }
        object Tapas : Appetizer() {
            override val menuName: String = "타파스"
            override val cost: Int = 5500
        }
        object CaesarSalad : Appetizer() {
            override val menuName: String = "시저샐러드"
            override val cost: Int = 8000
        }
    }

    sealed class MainDish : MenuType() {
        object TboneSteak : MainDish() {
            override val menuName: String = "티본스테이크"
            override val cost: Int = 55000
        }
        object BarbecueRibs : MainDish() {
            override val menuName: String = "바비큐립"
            override val cost: Int = 54000
        }
        object SeafoodPasta : MainDish() {
            override val menuName: String = "해산물파스타"
            override val cost: Int = 35000
        }
        object ChristmasPasta : MainDish() {
            override val menuName: String = "크리스마스파스타"
            override val cost: Int = 25000
        }
    }

    sealed class Dessert : MenuType() {
        object ChocolateCake : Dessert() {
            override val menuName: String = "초코케이크"
            override val cost: Int = 15000
        }
        object IceCream : Dessert() {
            override val menuName: String = "아이스크림"
            override val cost: Int = 5000
        }
    }

    sealed class Beverage : MenuType() {
        object ZeroCola : Beverage() {
            override val menuName: String = "제로콜라"
            override val cost: Int = 3000
        }
        object RedWine : Beverage() {
            override val menuName: String = "레드와인"
            override val cost: Int = 60000
        }
        object Champagne : Beverage() {
            override val menuName: String = "샴페인"
            override val cost: Int = 25000
        }
    }

    companion object {
        private val allMenuItems: List<MenuType> by lazy {
            listOf(
                Appetizer.MushroomSoup, Appetizer.Tapas, Appetizer.CaesarSalad,
                MainDish.TboneSteak, MainDish.BarbecueRibs, MainDish.SeafoodPasta, MainDish.ChristmasPasta,
                Dessert.ChocolateCake, Dessert.IceCream,
                Beverage.ZeroCola, Beverage.RedWine, Beverage.Champagne
            )
        }

        fun isMenuExists(menuName: String): Boolean {
            return allMenuItems.any { it.menuName == menuName }
        }

        fun getMenuType(menuName: String): MenuType {
            return allMenuItems.firstOrNull { it.menuName == menuName }
                ?: throw IllegalArgumentException("Menu not found: $menuName")
        }

        fun getMenuCost(menuName: String): Int {
            return getMenuType(menuName).cost
        }
    }
}
