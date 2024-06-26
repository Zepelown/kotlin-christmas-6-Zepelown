package christmas.model

class Date(private val date: Int?) {
    private val dayOfWeek : DayOfWeek = calculateDayOfWeek()
    init {
        require(!isNull())
        require(isVariableInRange())
    }

    fun getDate() : Int = date!!

    fun isWeekday() : Boolean = dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.FRIDAY
    fun isChristmasSeason() = if(date!! <= 25) true else false

    fun isSpecialDay() : Boolean{
        return when(date) {
            3,10,17,24,25,31 -> true
            else -> false
        }
    }

    private fun calculateDayOfWeek() : DayOfWeek {
        val remainderAfter7Division = date?.rem(7)
        return when(remainderAfter7Division){
            0 -> DayOfWeek.THURSDAY
            1 -> DayOfWeek.FRIDAY
            2 -> DayOfWeek.SATURDAY
            3 -> DayOfWeek.SUNDAY
            4 -> DayOfWeek.MONDAY
            5 -> DayOfWeek.TUESDAY
            6 -> DayOfWeek.WEDNESDAY
            else -> throw IllegalArgumentException()
        }
    }
    private fun isVariableInRange() = if(date!! >= 1 && date <= 31) true else false

    private fun isNull() = if(date == null) true else false

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