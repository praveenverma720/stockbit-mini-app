package com.didik.feature_watchlist.data.remote.response

import com.squareup.moshi.Json

data class CoinInfoResponse(
    @Json(name = "Id")
    val id: String? = null,

    @Json(name = "Name")
    val name: String? = null,

    @Json(name = "FullName")
    val fullName: String? = null
)