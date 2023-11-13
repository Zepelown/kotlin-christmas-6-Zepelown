package christmas

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
        readDate()
    }

    private fun readDate(){
        outputView.printDateInputMessage()
        val date = inputView.readDate()
    }
}