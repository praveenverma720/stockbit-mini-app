package com.didik.feature_watchlist.domain.repository

import com.didik.core.data.Result
import com.didik.feature_watchlist.domain.model.CryptoModel

interface IStockRepository {
    suspend fun getTopCrypto(page: Int, limit: Int): Result<List<CryptoModel>>
}