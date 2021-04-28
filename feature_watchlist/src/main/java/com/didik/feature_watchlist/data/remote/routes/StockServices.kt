package com.didik.feature_watchlist.data.remote.routes

import com.didik.feature_watchlist.data.remote.response.CryptoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface StockServices {

    @GET("data/top/totaltoptiervolfull")
    suspend fun getTopCrypto(
        @Query("page") page: Int,
        @Query("limit") limit: Int,
        @Query("tsym") tsym: String = "USD"
    ): Response<CryptoResponse>
}