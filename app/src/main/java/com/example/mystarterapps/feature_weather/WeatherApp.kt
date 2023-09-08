package com.example.mystarterapps.feature_weather

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.mystarterapps.feature_weather.ui.theme.DarkBlue
import com.example.mystarterapps.feature_weather.ui.theme.DeepBlue
import com.example.mystarterapps.feature_weather.ui.theme.WeatherAppTheme
import com.example.mystarterapps.feature_weather.presentation.weather.WeatherCard
import com.example.mystarterapps.feature_weather.presentation.weather.WeatherForecast
import com.example.mystarterapps.feature_weather.presentation.weather.WeatherViewModel

@Composable
fun WeatherApp(
    viewModel: WeatherViewModel
) {
    WeatherAppTheme {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(DarkBlue)
            ) {
                WeatherCard(
                    state = viewModel.state,
                    backgroundColor = DeepBlue
                )
                Spacer(modifier = Modifier.height(16.dp))
                WeatherForecast(state = viewModel.state)
            }
            if (viewModel.state.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            viewModel.state.error?.let { error ->
                Text(
                    text = error,
                    color = Color.Red,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}