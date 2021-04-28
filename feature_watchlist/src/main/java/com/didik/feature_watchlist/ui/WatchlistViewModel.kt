package com.didik.feature_watchlist.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.didik.feature_watchlist.domain.pagination.CryptoPagingSource
import com.didik.feature_watchlist.di.WatchlistModule
import com.didik.feature_watchlist.domain.usecase.StockUseCase

class WatchlistViewModel : ViewModel() {

    private val stockUseCase: StockUseCase = WatchlistModule().buildUseCase()

    val cryptoList = Pager(PagingConfig(1)) {
        CryptoPagingSource(stockUseCase)
    }.flow.cachedIn(viewModelScope)
}