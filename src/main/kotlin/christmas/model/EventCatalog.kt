package christmas.model

class EventCatalog(
    private val date: Date,
    private val totalCost: Int
) {
    private val eventCatalog = HashMap<EventType, Int>()

    init {
        calculateEventsOnDate()
    }

    fun getEventCatalog() = eventCatalog

    fun hasGiftEvent(): Boolean = eventCatalog.contains(EventType.GIFT_EVENT)

    fun hasEvent() : Boolean = !eventCatalog.isEmpty()
    fun getTotalEventDiscountCost(): Int = eventCatalog.values.sum()

    private fun calculateEventsOnDate() {
        calculateEventBasedOnDayOfWeek()
        calculateEventBasedOnChristmasDeal()
        calculateEventBasedOnSpecialDiscount()
        calculateEventBasedOnGiftEvent()
    }

    private fun calculateEventBasedOnDayOfWeek() {
        if (date.isWeekday()) {
            eventCatalog.put(EventType.WEEKDAY_DISCOUNT, 2023)
            return
        }
        eventCatalog.put(EventType.WEEKEND_DISCOUNT, 2023)
    }

    private fun calculateEventBasedOnChristmasDeal() {
        if (date.isChristmasSeason()) {
            eventCatalog.put(EventType.CHRISTMAS_DEAL, date.getDate() * 100 + 1000)
        }
    }

    private fun calculateEventBasedOnSpecialDiscount() {
        if (date.isSpecialDay()) {
            eventCatalog.put(EventType.SPECIAL_DISCOUNT, 1000)
        }
    }

    private fun calculateEventBasedOnGiftEvent() {
        if (totalCost >= 120000){
            eventCatalog.put(EventType.GIFT_EVENT, 25000)
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