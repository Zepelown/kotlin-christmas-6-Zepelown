package christmas.model

class Date(private val date: Int?) {
    init {
        requireNotNull(date)
        require(isVariableInRange())
    }
    private fun isVariableInRange() = if(date!! >= 1 && date <= 35) true else false
}