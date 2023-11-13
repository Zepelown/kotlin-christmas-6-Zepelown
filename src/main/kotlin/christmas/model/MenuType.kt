package christmas.model

sealed class MenuType {
    enum class Appetizer(val menuName: String, val cost: Int) {
        MushroomSoup("양송이수프", 6000),
        Tapas("타파스", 5500),
        CaesarSalad("시저샐러드", 8000)
    }

    enum class MainDish(val menuName: String, val cost: Int) {
        TboneSteak("티본스테이크", 55000),
        BarbecueRibs("바비큐립", 54000),
        SeafoodPasta("해산물파스타", 35000),
        ChristmasPasta("크리스마스파스타", 25000)
    }

    enum class Dessert(val menuName: String, val cost: Int) {
        ChocolateCake("초코케이크", 15000),
        IceCream("아이스크림", 5000)
    }

    enum class Beverage(val menuName: String, val cost: Int) {
        ZeroCola("제로콜라", 3000),
        RedWine("레드와인", 60000),
        Champagne("샴페인", 25000)
    }

    companion object {
        fun isMenuExists(menuName: String): Boolean {
            return Appetizer.values().any { it.menuName == menuName } ||
                    MainDish.values().any { it.menuName == menuName } ||
                    Dessert.values().any { it.menuName == menuName } ||
                    Beverage.values().any { it.menuName == menuName }
        }
    }
}




