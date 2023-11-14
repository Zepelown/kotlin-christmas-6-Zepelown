package christmas.model

class EventCatalog(
    private val date: Date,
    private val totalCost: Int
) {
    private val events = ArrayList<EventType>()

    init {
        calculateEventsOnDate()
    }

    fun hasChristmasDeal(): Boolean = events.contains(EventType.CHRISTMAS_DEAL)

    fun hasWeekdayDiscount(): Boolean = events.contains(EventType.WEEKDAY_DISCOUNT)

    fun hasWeekendDiscount(): Boolean = events.contains(EventType.WEEKEND_DISCOUNT)

    fun hasSpecialDiscount(): Boolean = events.contains(EventType.SPECIAL_DISCOUNT)

    fun hasGiftEvent(): Boolean = events.contains(EventType.GIFT_EVENT)

    private fun calculateEventsOnDate() {
        calculateEventBasedOnDayOfWeek()
        calculateEventBasedOnChristmasDeal()
        calculateEventBasedOnSpecialDiscount()
        calculateEventBasedOnGiftEvent()
    }

    private fun calculateEventBasedOnDayOfWeek() {
        if (date.isWeekday()) {
            events.add(EventType.WEEKDAY_DISCOUNT)
            return
        }
        events.add(EventType.WEEKEND_DISCOUNT)
    }

    private fun calculateEventBasedOnChristmasDeal() {
        if (date.isChristmasSeason()) {
            events.add(EventType.CHRISTMAS_DEAL)
        }
    }

    private fun calculateEventBasedOnSpecialDiscount() {
        if (date.isSpecialDay()) {
            events.add(EventType.SPECIAL_DISCOUNT)
        }
    }

    private fun calculateEventBasedOnGiftEvent() {
        if (totalCost >= 120000){
            events.add(EventType.GIFT_EVENT)
        }
    }

    enum class EventType {
        CHRISTMAS_DEAL,
        WEEKDAY_DISCOUNT,
        WEEKEND_DISCOUNT,
        SPECIAL_DISCOUNT,
        GIFT_EVENT
    }
}