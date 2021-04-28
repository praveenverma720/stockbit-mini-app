package com.didik.stockbitminiapp.app

import android.app.Application
import com.didik.feature_watchlist.di.WatchlistModule
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class StockbitApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            modules(
                WatchlistModule.module
            )
        }
    }

}