package christmas

import christmas.model.Date
import christmas.model.EventCatalog
import christmas.model.Order
import christmas.view.console.InputView
import christmas.view.console.OutputView

class EventPlanner {
    private val inputView = InputView()
    private val outputView = OutputView()

    init {
        startPlanning()
    }

    fun startPlanning(){
        outputView.printStartMessage()
        val date = readDate()
        val order = readOrder()
        val eventCatalog = EventCatalog(date,order.getTotalCost())
        displayEventBenefits(date, order, eventCatalog)
    }

    private fun readDate() : Date {
        outputView.printDateInputMessage()
        return inputView.readDate()
    }

    private fun readOrder() : Order {
        outputView.printOrderInputMessage()
        return inputView.readOrder()
    }

    private fun displayEventBenefits(date: Date, order: Order, eventCatalog: EventCatalog){
        outputView.printEventBenefitsTitleMessage(date)
        outputView.printOrder(order)
        outputView.printTotalCost(order)
        outputView.printGiftEvent(eventCatalog)
    }
}