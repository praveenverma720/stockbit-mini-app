package com.didik.feature_watchlist.data.remote

import com.didik.feature_watchlist.data.remote.response.CryptoResponse
import com.didik.feature_watchlist.data.remote.routes.StockServices
import retrofit2.Response

class StockRemoteDataSource constructor(private val stockServices: StockServices) {

    suspend fun getTopCrypto(
        page: Int,
        limit: Int
    ): Response<CryptoResponse> {
        return stockServices.getTopCrypto(page, limit)
    }
}