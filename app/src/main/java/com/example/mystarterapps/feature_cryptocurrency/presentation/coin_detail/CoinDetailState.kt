package com.example.mystarterapps.feature_cryptocurrency.presentation.coin_detail

import com.example.mystarterapps.feature_cryptocurrency.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
