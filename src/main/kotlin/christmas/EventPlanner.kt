package christmas

import christmas.model.Date
import christmas.model.Order
import christmas.view.InputView
import christmas.view.OutputView

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
        displayEventBenefits(date, order)
    }

    private fun readDate() : Date {
        outputView.printDateInputMessage()
        return inputView.readDate()
    }

    private fun readOrder() : Order {
        outputView.printOrderInputMessage()
        return inputView.readOrder()
    }

    private fun displayEventBenefits(date: Date, order: Order){
        outputView.printEventBenefitsTitleMessage(date)
        println()
        outputView.printOrder(order)
    }
}