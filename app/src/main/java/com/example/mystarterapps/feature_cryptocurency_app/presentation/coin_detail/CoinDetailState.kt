package com.example.mystarterapps.feature_cryptocurency_app.presentation.coin_detail

import com.example.mystarterapps.feature_cryptocurency_app.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
