package com.example.mystarterapps.feature_cryptocurency_app.presentation.coin_list

import com.example.mystarterapps.feature_cryptocurency_app.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
