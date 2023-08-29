package com.example.mystarterapps.feature_cryptocurency_app.domain.model

import com.example.mystarterapps.feature_cryptocurency_app.data.remote.dto.TeamMember

data class CoinDetail(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<TeamMember>
)
