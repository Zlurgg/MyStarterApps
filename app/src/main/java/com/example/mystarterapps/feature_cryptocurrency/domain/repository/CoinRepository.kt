package com.example.mystarterapps.feature_cryptocurrency.domain.repository

import com.example.mystarterapps.feature_cryptocurrency.data.remote.dto.CoinDetailDto
import com.example.mystarterapps.feature_cryptocurrency.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}