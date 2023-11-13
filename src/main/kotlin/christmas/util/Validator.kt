package christmas.util

import christmas.model.Date

object Validator {
    fun validateDate(date : Int?) : Boolean{
        try {
            Date(date)
        } catch (e: IllegalArgumentException){
            return false
        }
        return true
    }
}