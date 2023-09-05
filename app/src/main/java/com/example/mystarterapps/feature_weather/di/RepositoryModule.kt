package com.example.mystarterapps.feature_weather.di

import com.example.mystarterapps.feature_weather.data.location.DefaultLocationTracker
import com.example.mystarterapps.feature_weather.data.repository.WeatherRepositoryImpl
import com.example.mystarterapps.feature_weather.domain.location.LocationTracker
import com.example.mystarterapps.feature_weather.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindWeatherRepository(
        weatherRepositoryImpl: WeatherRepositoryImpl
    ): WeatherRepository
}