package christmas.model

class EventCatalog(
    private val date: Date,
    private val totalCost: Int,
    private val order: Order
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
        val eventType = if (date.isWeekday()) EventType.WEEKDAY_DISCOUNT else EventType.WEEKEND_DISCOUNT
        val totalAmount = if (date.isWeekday()) order.getTotalDessertAmount() else order.getTotalMainDishAmount()

        if (totalAmount == 0) return

        eventCatalog.put(eventType, 2023 * totalAmount)
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

    enum class EventType(val displayName:String) {
        CHRISTMAS_DEAL("크리스마스 디데이 할인"),
        WEEKDAY_DISCOUNT("평일 할인"),
        WEEKEND_DISCOUNT("주말 할인"),
        SPECIAL_DISCOUNT("특별 할인"),
        GIFT_EVENT("증정 이벤트")
    }
}