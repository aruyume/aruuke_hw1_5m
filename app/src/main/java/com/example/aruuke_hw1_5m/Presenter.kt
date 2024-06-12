package com.example.aruuke_hw1_5m

class Presenter {

    private val model = CounterModel()
    private var view: CounterView? = null

    fun attachView(view: CounterView) {
        this.view = view
    }

    fun onDecrementBtnClicked() {
        model.dec()
        view?.updateCount(model.getResult())
        checkToastAndColor(model.getResult())
    }

    fun onIncrementBtnClicked() {
        model.inc()
        view?.updateCount(model.getResult())
        checkToastAndColor(model.getResult())
    }

    fun detachView() {
        this.view = null
    }

    private fun checkToastAndColor(count: Int) {
        when (count) {
            10 -> view?.showToast("Поздравляем")
            15 -> view?.changeTextColor()
        }
    }
}