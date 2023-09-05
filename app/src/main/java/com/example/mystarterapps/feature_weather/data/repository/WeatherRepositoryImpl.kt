package com.example.mystarterapps.feature_weather.data.repository

import com.example.mystarterapps.feature_weather.common.util.Resource
import com.example.mystarterapps.feature_weather.data.mappers.toWeatherInfo
import com.example.mystarterapps.feature_weather.data.remote.WeatherApi
import com.example.mystarterapps.feature_weather.domain.repository.WeatherRepository
import com.example.mystarterapps.feature_weather.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject  constructor(
    private val api: WeatherApi
): WeatherRepository {

    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )
        } catch(e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred")
        }
    }
}