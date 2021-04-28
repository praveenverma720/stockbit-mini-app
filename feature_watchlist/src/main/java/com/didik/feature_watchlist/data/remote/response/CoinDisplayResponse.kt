package com.didik.feature_watchlist.data.remote.response

import com.squareup.moshi.Json

data class CoinDisplayResponse(
    @Json(name = "USD")
    val usd: USDResponse? = null
)