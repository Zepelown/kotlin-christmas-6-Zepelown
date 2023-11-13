package christmas.util

import christmas.model.Date
import christmas.model.OrderItem
import christmas.model.Order

object InputValidator {
    fun validateDate(date: Int?): Boolean {
        try {
            Date(date)
        } catch (e: IllegalArgumentException) {
            return false
        }
        return true
    }
}