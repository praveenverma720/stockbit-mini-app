package com.didik.feature_watchlist.data.repository

import com.didik.core.data.Result
import com.didik.feature_watchlist.data.mapper.CryptoMapper
import com.didik.feature_watchlist.data.remote.StockRemoteDataSource
import com.didik.feature_watchlist.domain.model.CryptoModel
import com.didik.feature_watchlist.domain.repository.IStockRepository

class StockRepository constructor(
    private val remoteDataSource: StockRemoteDataSource,
    private val mapper: CryptoMapper
) : IStockRepository {

    override suspend fun getTopCrypto(page: Int, limit: Int): Result<List<CryptoModel>> {
        val response = remoteDataSource.getTopCrypto(page, limit)

        return if (response.isSuccessful) {
            val data = response.body()?.data.orEmpty()
            val cryptoList = mapper.mapToListDomain(data)
            Result.Success(cryptoList)
        } else {
            Result.Failure(Throwable(response.message()))
        }
    }
}