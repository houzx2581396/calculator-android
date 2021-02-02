package com.example.calculator

import android.content.Context
import android.content.res.Configuration
import android.graphics.Color
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.AppCompatButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var digit_on_screen = StringBuilder()
    var operation: String = " "
    var leftHandSide: Double = 0.0
    var rightHandSide: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        result_view.text = "0"
        addInt()
    }

    private fun addInt() {
        //數字按鈕
        button_one.setOnClickListener {
            showInt("1")
        }
        button_two.setOnClickListener {
            showInt("2")
        }
        button_three.setOnClickListener {
            showInt("3")
        }
        button_four.setOnClickListener {
            showInt("4")
        }
        button_five.setOnClickListener {
            showInt("5")
        }
        button_six.setOnClickListener {
            showInt("6")
        }
        button_seven.setOnClickListener {
            showInt("7")
        }
        button_eight.setOnClickListener {
            showInt("8")
        }
        button_nine.setOnClickListener {
            showInt("9")
        }
        button_zero.setOnClickListener {
            showInt("0")
        }
        button_dot.setOnClickListener {
            showInt(".")
        }
        button_negative.setOnClickListener {
            val showNum = digit_on_screen.toString()
            if (showNum.toInt() != 0) {
                val negativeNum = showNum.toInt().unaryMinus().toString()
                result_view.text = negativeNum
                digit_on_screen.clear()
                digit_on_screen.append(negativeNum)
            }
        }

        button_percent.setOnClickListener {
            val percent = digit_on_screen.toString().toDouble() * 0.01
            result_view.text = percent.toString()
            digit_on_screen.clear()
            digit_on_screen.append(percent.toString())
        }

        //清除按鈕
        button_clear.setOnClickListener {
            result_view.text = "0"
            digit_on_screen.clear()
        }
        button_backspace.setOnClickListener {
            digit_on_screen.deleteCharAt(digit_on_screen.length - 1)
            result_view.text = digit_on_screen.toString()
        }

        //算法按鈕
        button_multiply.setOnClickListener {
            selectOperation("multiply")
        }
        button_divide.setOnClickListener {
            selectOperation("divide")
        }
        button_add.setOnClickListener {
            selectOperation("add")
        }
        button_subtract.setOnClickListener {
            selectOperation("subtract")
        }

        button_equal.setOnClickListener {
            equal()
        }
    }

    private fun showInt(digit: String) {
        digit_on_screen.append(digit)
        result_view.text = digit_on_screen.toString()
    }

    private fun selectOperation(c: String) {
        operation = c
        leftHandSide = digit_on_screen.toString().toDouble()
        digit_on_screen.clear()
        result_view.text = "0"
    }

    private fun equal() {
        rightHandSide = digit_on_screen.toString().toDouble()
        digit_on_screen.clear()
        when (operation) {
            "add" -> {
                val equal = leftHandSide.plus(rightHandSide)
                result_view.text = equal.toString()
            }
            "multiply" -> {
                val equal = leftHandSide.times(rightHandSide)
                result_view.text = equal.toString()
            }
            "divide" -> {
                val equal = leftHandSide.div(rightHandSide)
                result_view.text = equal.toString()
            }
            "subtract" -> {
                val equal = leftHandSide.minus(rightHandSide)
                result_view.text = equal.toString()
            }
        }
    }

    fun isDarkTheme(context: Context): Boolean {
        val flag = context.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        return flag == Configuration.UI_MODE_NIGHT_YES
    }
}