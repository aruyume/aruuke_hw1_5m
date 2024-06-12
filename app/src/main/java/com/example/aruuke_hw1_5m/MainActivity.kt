package com.example.aruuke_hw1_5m

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.aruuke_hw1_5m.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CounterView {
    private val presenter = Presenter()

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        presenter.attachView(this)

        with(binding) {
            btnInc.setOnClickListener {
                presenter.onIncrementBtnClicked()
            }
            btnDec.setOnClickListener {
                presenter.onDecrementBtnClicked()
            }
        }
    }

    override fun updateCount(count: Int) {
        binding.tvCounterResult.text = count.toString()
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun changeTextColor() {
        binding.tvCounterResult.setTextColor(Color.GREEN)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}