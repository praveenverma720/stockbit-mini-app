package com.didik.feature_watchlist.data.remote.response

import com.squareup.moshi.Json

data class USDResponse(
    @Json(name = "PRICE")
    val price: String? = null,

    @Json(name = "CHANGEPCTDAY")
    val changePercentageDay: String? = null
)