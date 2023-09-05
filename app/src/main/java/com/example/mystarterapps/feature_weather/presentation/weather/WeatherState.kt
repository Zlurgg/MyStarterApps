package com.example.mystarterapps.feature_weather.presentation.weather

import com.example.mystarterapps.feature_weather.domain.weather.WeatherInfo

data class WeatherState(
    val weatherInfo: WeatherInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
