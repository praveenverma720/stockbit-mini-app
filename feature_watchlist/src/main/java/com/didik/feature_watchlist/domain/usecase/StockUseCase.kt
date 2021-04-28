package com.didik.feature_watchlist.domain.usecase

import com.didik.core.data.Result
import com.didik.core.dispatcher.DispatcherProvider
import com.didik.feature_watchlist.domain.model.CryptoModel
import com.didik.feature_watchlist.domain.repository.IStockRepository
import kotlinx.coroutines.withContext

class StockUseCase constructor(
    private val repository: IStockRepository,
    private val dispatcher: DispatcherProvider
) {

    suspend fun getTopCrypto(
        page: Int,
        limit: Int
    ): Result<List<CryptoModel>> {
        return try {
            withContext(dispatcher.io) {
                repository.getTopCrypto(page, limit)
            }
        } catch (exceptions: Exception) {
            Result.Failure(Throwable(exceptions.message))
        }
    }
}