package christmas.model

import com.sun.tools.javac.Main
import java.awt.Menu


sealed interface MenuCategory {
    val menuName: String
    val cost: Int
}

sealed class MenuType {
    enum class Appetizer(override val menuName: String, override val cost: Int) : MenuCategory {
        MushroomSoup("양송이수프", 6000),
        Tapas("타파스", 5500),
        CaesarSalad("시저샐러드", 8000);
    }

    enum class MainDish(override val menuName: String, override val cost: Int) : MenuCategory {
        TboneSteak("티본스테이크", 55000),
        BarbecueRibs("바비큐립", 54000),
        SeafoodPasta("해산물파스타", 35000),
        ChristmasPasta("크리스마스파스타", 25000);
    }

    enum class Dessert(override val menuName: String, override val cost: Int) : MenuCategory {
        ChocolateCake("초코케이크", 15000),
        IceCream("아이스크림", 5000);
    }

    enum class Beverage(override val menuName: String, override val cost: Int) : MenuCategory {
        ZeroCola("제로콜라", 3000),
        RedWine("레드와인", 60000),
        Champagne("샴페인", 25000);
    }

    companion object {
        fun isMenuExists(menuName: String): Boolean {
            return Appetizer.values().any { it.menuName == menuName } ||
                    MainDish.values().any { it.menuName == menuName } ||
                    Dessert.values().any { it.menuName == menuName } ||
                    Beverage.values().any { it.menuName == menuName }
        }

        fun getMenuCategory(menuName: String): MenuCategory {
            return when {
                Appetizer.values().any { it.menuName == menuName } -> Appetizer.values()
                    .first { it.menuName == menuName }
                MainDish.values().any { it.menuName == menuName } -> MainDish.values().first { it.menuName == menuName }
                Dessert.values().any { it.menuName == menuName } -> Dessert.values().first { it.menuName == menuName }
                Beverage.values().any { it.menuName == menuName } -> Beverage.values().first { it.menuName == menuName }
                else -> throw IllegalArgumentException()
            }
        }

        fun getMenuCost(menuName: String): Int {
            return when {
                Appetizer.values().any { it.menuName == menuName } -> Appetizer.values()
                    .first { it.menuName == menuName }.cost

                MainDish.values().any { it.menuName == menuName } -> MainDish.values()
                    .first { it.menuName == menuName }.cost

                Dessert.values().any { it.menuName == menuName } -> Dessert.values()
                    .first { it.menuName == menuName }.cost

                Beverage.values().any { it.menuName == menuName } -> Beverage.values()
                    .first { it.menuName == menuName }.cost

                else -> throw IllegalArgumentException()
            }
        }


    }
}




