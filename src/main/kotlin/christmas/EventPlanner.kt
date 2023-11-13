package christmas

import christmas.view.OutputView

class EventPlanner {
    private val outputView = OutputView()

    init {
        startPlanning()
    }

    fun startPlanning(){
        outputView.printStartMessage()
    }
}