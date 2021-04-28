package com.didik.feature_watchlist.data.remote.response

import com.squareup.moshi.Json

data class CryptoDataResponse(
    @Json(name = "CoinInfo")
    val coinInfo: CoinInfoResponse? = null,

    @Json(name = "DISPLAY")
    val display: CoinDisplayResponse? = null
)