package com.example.calculator

class CalculatorHelper {
    companion object {
        fun add(left_number: Double, right_number: Double): Double {
            return left_number + right_number
        }

        fun subtract(left_number: Double, right_number: Double): Double {
            return left_number - right_number
        }

        fun divide(left_number: Double, right_number: Double): Double {
            return left_number / right_number
        }

        fun multiply(left_number: Double, right_number: Double): Double {
            return left_number * right_number
        }
    }
}