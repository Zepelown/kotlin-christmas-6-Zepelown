package christmas.model

class Date(private val date: Int?) {
    private val dayOfWeek : DayOfWeek = calculateDayOfWeek()
    init {
        requireNotNull(date)
        require(isVariableInRange())
    }

    fun isWeekday() : Boolean{
        if(dayOfWeek in DayOfWeek.SUNDAY .. DayOfWeek.THURSDAY) {
            return true
        }
        return false
    }

    fun isChristmasSeason() = if(date!! <= 25) true else false

    fun isSpecialDay() : Boolean{
        return when(date) {
            3,10,17,24,25,31 -> true
            else -> false
        }
    }

    private fun calculateDayOfWeek() : DayOfWeek {
        val remainderAfter7Division = date!! % 7
        return when(remainderAfter7Division){
            0 -> DayOfWeek.THURSDAY
            1 -> DayOfWeek.FRIDAY
            2 -> DayOfWeek.SATURDAY
            3 -> DayOfWeek.SUNDAY
            4 -> DayOfWeek.MONDAY
            5 -> DayOfWeek.TUESDAY
            6 -> DayOfWeek.WEDNESDAY
            else -> DayOfWeek.FRIDAY
        }
    }
    private fun isVariableInRange() = if(date!! >= 1 && date <= 31) true else false

    enum class DayOfWeek(){
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY
    }
}