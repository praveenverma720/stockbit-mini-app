package com.didik.feature_watchlist.data.remote.routes

import com.didik.feature_watchlist.data.remote.response.CryptoResponse
import com.didik.feature_watchlist.helpers.Faker
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.unmockkAll
import retrofit2.Response

class StockServicesTest : ShouldSpec({

    val faker = Faker
    val fakePage = faker.int
    val fakeLimit = faker.int
    val fakeTSYM = faker.string
    val fakeResponse: Response<CryptoResponse> = mockk()
    lateinit var stockServices: StockServices

    beforeTest {
        stockServices = mockk()
    }

    afterTest {
        unmockkAll()
    }

    context("get top crypto") {
        should("return response correctly when completed parameters") {
            // Given
            coEvery {
                stockServices.getTopCrypto(
                    page = fakePage,
                    limit = fakeLimit,
                    tsym = fakeTSYM
                )
            } returns fakeResponse

            // When
            val response = stockServices.getTopCrypto(
                page = fakePage,
                limit = fakeLimit,
                tsym = fakeTSYM
            )

            // Then
            response shouldBe fakeResponse
        }

        should("return response correctly when without tsym") {
            // Given
            coEvery { stockServices.getTopCrypto(fakePage, fakeLimit) } returns fakeResponse

            // When
            val response = stockServices.getTopCrypto(fakePage, fakeLimit)

            // Then
            response shouldBe fakeResponse
        }
    }

})