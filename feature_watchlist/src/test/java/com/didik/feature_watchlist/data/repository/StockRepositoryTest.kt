package com.didik.feature_watchlist.data.repository

import com.didik.core.data.Result
import com.didik.feature_watchlist.data.mapper.CryptoMapper
import com.didik.feature_watchlist.data.remote.StockRemoteDataSource
import com.didik.feature_watchlist.data.remote.response.CryptoDataResponse
import com.didik.feature_watchlist.data.remote.response.CryptoResponse
import com.didik.feature_watchlist.domain.model.CryptoModel
import com.didik.feature_watchlist.helpers.Faker
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import io.mockk.*
import retrofit2.Response

class StockRepositoryTest : ShouldSpec({

    val faker = Faker
    val remoteDataSource: StockRemoteDataSource = mockk()
    val mapper: CryptoMapper = mockk()
    lateinit var repository: StockRepository

    beforeTest {
        repository = spyk(
            StockRepository(
                remoteDataSource = remoteDataSource,
                mapper = mapper
            )
        )
    }

    afterTest {
        unmockkAll()
    }

    context("get top crypto") {
        val fakePage = faker.int
        val fakeLimit = faker.int
        val fakeResponse: Response<CryptoResponse> = mockk()
        val fakeData: List<CryptoDataResponse> = mockk()

        should("result success when response is successful") {
            // Given
            val fakeResult: List<CryptoModel> = mockk()

            every { fakeResponse.isSuccessful } returns true
            every { fakeResponse.body()?.data } returns fakeData
            every { mapper.mapToListDomain(any()) } returns fakeResult
            coEvery { remoteDataSource.getTopCrypto(fakePage, fakeLimit) } returns fakeResponse

            // When
            val result = repository.getTopCrypto(fakePage, fakeLimit)

            // Then
            result shouldBe Result.Success(fakeResult)
            coVerify(exactly = 1) { remoteDataSource.getTopCrypto(fakePage, fakeLimit) }
            verify(exactly = 1) { mapper.mapToListDomain(fakeData) }
        }

        should("result failure when response is failed") {
            // Given
            val fakeMessage = faker.string

            every { fakeResponse.isSuccessful } returns false
            every { fakeResponse.message() } returns fakeMessage
            coEvery { remoteDataSource.getTopCrypto(fakePage, fakeLimit) } returns fakeResponse

            // When
            val result = repository.getTopCrypto(fakePage, fakeLimit)

            // Then
            if (result is Result.Failure) {
                result.throwable?.message shouldBe fakeMessage
            }
        }
    }

})