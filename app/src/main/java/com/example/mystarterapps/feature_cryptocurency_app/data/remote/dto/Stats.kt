package com.example.mystarterapps.feature_cryptocurency_app.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Stats(
    val contributors: Int,
    val followers: Int,
    val stars: Int,
    val subscribers: Int
)