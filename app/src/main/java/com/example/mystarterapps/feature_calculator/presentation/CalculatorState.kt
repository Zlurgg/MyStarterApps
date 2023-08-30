package com.example.mystarterapps.feature_calculator.presentation

import com.example.mystarterapps.feature_calculator.common.CalculatorOperation

data class CalculatorState(
    val number1: String = "",
    val number2: String = "",
    val operation: CalculatorOperation? = null
)
