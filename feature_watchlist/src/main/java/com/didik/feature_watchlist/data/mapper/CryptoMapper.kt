package com.didik.feature_watchlist.data.mapper

import androidx.annotation.VisibleForTesting
import com.didik.feature_watchlist.data.remote.response.CryptoDataResponse
import com.didik.feature_watchlist.domain.model.CryptoModel

class CryptoMapper {

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    fun mapToDomain(response: CryptoDataResponse): CryptoModel {
        return with(response) {
            CryptoModel(
                id = coinInfo?.id.orEmpty(),
                name = coinInfo?.name ?: "Unknown",
                fullName = coinInfo?.fullName ?: "Unknown",
                price = display?.usd?.price ?: "-",
                changePercentageDay = display?.usd?.changePercentageDay?.toDoubleOrNull() ?: 0.0
            )
        }
    }

    fun mapToListDomain(response: List<CryptoDataResponse>): List<CryptoModel> {
        return response.map { cryptoData ->
            mapToDomain(cryptoData)
        }
    }
}