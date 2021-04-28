package com.didik.feature_watchlist.data.remote

import com.didik.feature_watchlist.data.remote.response.CryptoResponse
import com.didik.feature_watchlist.data.remote.routes.StockServices
import com.didik.feature_watchlist.helpers.Faker
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import io.mockk.*
import retrofit2.Response

class StockRemoteDataSourceTest : ShouldSpec({

    val faker = Faker
    val stockServices: StockServices = mockk()
    lateinit var remoteDataSource: StockRemoteDataSource

    beforeTest {
        remoteDataSource = spyk(StockRemoteDataSource(stockServices))
    }

    afterTest {
        unmockkAll()
    }

    context("get top crypto") {
        should("calling API services and return response correctly") {
            // Given
            val fakePage = faker.int
            val fakeLimit = faker.int
            val fakeResponse: Response<CryptoResponse> = mockk()

            coEvery { stockServices.getTopCrypto(fakePage, fakeLimit) } returns fakeResponse

            // When
            val response = remoteDataSource.getTopCrypto(fakePage, fakeLimit)

            // Then
            response shouldBe fakeResponse
            coVerify(exactly = 1) { stockServices.getTopCrypto(fakePage, fakeLimit) }
        }
    }

})