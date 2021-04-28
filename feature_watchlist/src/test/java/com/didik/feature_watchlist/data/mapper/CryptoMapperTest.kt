package com.didik.feature_watchlist.data.mapper

import com.didik.feature_watchlist.data.remote.response.CoinDisplayResponse
import com.didik.feature_watchlist.data.remote.response.CoinInfoResponse
import com.didik.feature_watchlist.data.remote.response.CryptoDataResponse
import com.didik.feature_watchlist.data.remote.response.USDResponse
import com.didik.feature_watchlist.domain.model.CryptoModel
import com.didik.feature_watchlist.helpers.Faker
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.instanceOf
import io.mockk.*

class CryptoMapperTest : ShouldSpec({

    val faker = Faker
    lateinit var mapper: CryptoMapper

    beforeTest {
        mapper = spyk(CryptoMapper())
    }

    afterTest {
        unmockkAll()
    }

    context("map to domain") {
        should("map crypto data response into crypto model") {
            // Given
            val fakeCoinInfoResponse = spyk(
                CoinInfoResponse(
                    id = faker.string,
                    name = faker.string,
                    fullName = faker.string
                )
            )
            val fakeUSDResponse = spyk(
                USDResponse(
                    price = faker.numericalString,
                    changePercentageDay = faker.numericalString
                )
            )
            val fakeCoinDisplayResponse = spyk(CoinDisplayResponse(fakeUSDResponse))
            val fakeCryptoDataResponse = spyk(
                CryptoDataResponse(
                    coinInfo = fakeCoinInfoResponse,
                    display = fakeCoinDisplayResponse
                )
            )

            // When
            val result = mapper.mapToDomain(fakeCryptoDataResponse)

            with(fakeCryptoDataResponse) {
                result.id shouldBe coinInfo?.id
                result.name shouldBe coinInfo?.name
                result.fullName shouldBe coinInfo?.fullName
                result.price shouldBe display?.usd?.price
                result.changePercentageDay shouldBe display?.usd?.changePercentageDay?.toDouble()
            }
        }
    }

    context("map to list domain") {
        should("map crypto data response list into crypto model list") {
            // Given
            val fakeResponse: List<CryptoDataResponse> = mockk(relaxed = true)

            every { mapper.mapToDomain(any()) } returns mockk(relaxed = true)

            // When
            val result = mapper.mapToListDomain(fakeResponse)

            // Then
            result shouldBe instanceOf<List<CryptoModel>>()
            verify {
                fakeResponse.map { mapper.mapToDomain(it) }
            }
        }
    }

})