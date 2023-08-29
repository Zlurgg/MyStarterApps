package com.example.mystarterapps.feature_cryptocurency_app.domain.repository

import com.example.mystarterapps.feature_cryptocurency_app.data.remote.dto.CoinDetailDto
import com.example.mystarterapps.feature_cryptocurency_app.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}