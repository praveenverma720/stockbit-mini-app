package com.didik.feature_watchlist.domain.model

data class CryptoModel(
    val id: String,
    val name: String,
    val fullName: String,
    val price: String,
    val changePercentageDay: Double,
)