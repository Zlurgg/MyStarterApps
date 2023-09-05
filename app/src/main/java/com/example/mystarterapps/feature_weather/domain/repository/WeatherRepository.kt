package com.example.mystarterapps.feature_weather.domain.repository

import com.example.mystarterapps.feature_weather.common.util.Resource
import com.example.mystarterapps.feature_weather.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(
        lat: Double,
        long: Double
    ) : Resource<WeatherInfo>
}