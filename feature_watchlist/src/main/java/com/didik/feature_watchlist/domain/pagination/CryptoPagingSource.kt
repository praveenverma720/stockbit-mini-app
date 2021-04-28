package com.didik.feature_watchlist.domain.pagination

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.didik.core.data.Result
import com.didik.feature_watchlist.domain.model.CryptoModel
import com.didik.feature_watchlist.domain.usecase.StockUseCase
import java.io.IOException

class CryptoPagingSource(
    private val stockUseCase: StockUseCase
) : PagingSource<Int, CryptoModel>() {

    override fun getRefreshKey(state: PagingState<Int, CryptoModel>): Int = 0

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CryptoModel> {
        return try {
            val currentPage = params.key ?: 0
            val result = stockUseCase.getTopCrypto(currentPage, LIMIT_DATA)
            val nextPage = currentPage + 1
            val previousPage = if (currentPage > 1) {
                currentPage - 1
            } else {
                null
            }
            when (result) {
                is Result.Success -> {
                    LoadResult.Page(
                        data = result.data,
                        prevKey = previousPage,
                        nextKey = nextPage
                    )
                }
                is Result.Failure -> {
                    LoadResult.Error(result.throwable ?: Throwable(IOException()))
                }
            }

        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }

    companion object {
        private const val LIMIT_DATA = 50
    }
}