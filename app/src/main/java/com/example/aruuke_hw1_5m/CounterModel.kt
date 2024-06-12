package com.example.aruuke_hw1_5m

class CounterModel {

    private var count = 0

    fun inc(){
        count++
    }

    fun dec(){
        count--
    }

    fun getResult() = count
}