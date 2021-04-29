package com.didik.feature_watchlist.di

import com.didik.core.dispatcher.AppCoroutineDispatcher
import com.didik.core.dispatcher.DispatcherProvider
import com.didik.core.network.Network
import com.didik.feature_watchlist.data.mapper.CryptoMapper
import com.didik.feature_watchlist.data.remote.StockRemoteDataSource
import com.didik.feature_watchlist.data.remote.routes.StockServices
import com.didik.feature_watchlist.data.repository.StockRepository
import com.didik.feature_watchlist.domain.repository.IStockRepository
import com.didik.feature_watchlist.domain.usecase.StockUseCase
import com.didik.feature_watchlist.ui.WatchlistViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object WatchlistModule {

    private fun provideStockServices(): StockServices {
        return Network
            .builder()
            .create(StockServices::class.java)
    }

    private fun provideStockRemoteDataSource(services: StockServices): StockRemoteDataSource {
        return StockRemoteDataSource(services)
    }

    private fun provideCryptoMapper(): CryptoMapper = CryptoMapper()

    private fun provideStockRepository(
        remoteDataSource: StockRemoteDataSource,
        mapper: CryptoMapper
    ): IStockRepository = StockRepository(remoteDataSource, mapper)

    private fun provideAppDispatcher(): DispatcherProvider = AppCoroutineDispatcher()

    private fun provideStockUseCase(
        repository: IStockRepository,
        dispatcher: DispatcherProvider
    ): StockUseCase = StockUseCase(repository, dispatcher)

    val module = module {
        single { provideStockServices() }
        single { provideStockRemoteDataSource(get()) }
        single { provideCryptoMapper() }
        single { provideStockRepository(get(), get()) }
        single { provideAppDispatcher() }
        single { provideStockUseCase(get(), get()) }
        viewModel { WatchlistViewModel(get()) }
    }

}