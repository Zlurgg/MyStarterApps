package com.example.mystarterapps.feature_calculator

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mystarterapps.feature_calculator.presentation.Calculator
import com.example.mystarterapps.feature_calculator.presentation.CalculatorViewModel

@Composable
fun CalculatorApp() {
    val viewModel: CalculatorViewModel = hiltViewModel()
    val state = viewModel.state
    val buttonSpacing = 8.dp
    Calculator(
        state = state,
        onAction = viewModel::onAction,
        buttonSpacing = buttonSpacing,
    )
}