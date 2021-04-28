package com.didik.feature_watchlist.data.remote.response

import com.squareup.moshi.Json

data class CryptoResponse(
    @Json(name = "Data")
    val data: List<CryptoDataResponse>? = null
)

