package com.example.mystarterapps.feature_stock_market.data.remote.dto

import com.squareup.moshi.Json

data class IntradayInfoDto(
    val timeStamp: String,
    val close: Double,
)
