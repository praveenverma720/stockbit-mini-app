package com.didik.feature_watchlist.domain.usecase

import com.didik.core.data.Result
import com.didik.core.dispatcher.TestCoroutineDispatcher
import com.didik.feature_watchlist.data.repository.StockRepository
import com.didik.feature_watchlist.domain.model.CryptoModel
import com.didik.feature_watchlist.helpers.Faker
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import io.mockk.*

class StockUseCaseTest : ShouldSpec({

    val faker = Faker

    lateinit var repository: StockRepository
    lateinit var dispatcher: TestCoroutineDispatcher
    lateinit var useCase: StockUseCase

    beforeTest {
        repository = mockk()
        dispatcher = spyk()
        useCase = spyk(
            StockUseCase(
                repository = repository,
                dispatcher = dispatcher
            )
        )
    }

    afterTest {
        unmockkAll()
    }

    context("get top crypto") {
        val fakePage = faker.int
        val fakeLimit = faker.int

        should("return result crypto model list correctly") {
            // Given
            val fakeResult: Result<List<CryptoModel>> = mockk()

            coEvery { repository.getTopCrypto(fakePage, fakeLimit) } returns fakeResult

            // When
            val result = useCase.getTopCrypto(fakePage, fakeLimit)

            // Then
            result shouldBe fakeResult
            coVerify { repository.getTopCrypto(fakePage, fakeLimit) }
        }

        should("return result failure when catch exception") {
            // Given
            val exception = shouldThrow<Exception> {
                repository.getTopCrypto(fakePage, fakeLimit)
            }

            val result = useCase.getTopCrypto(fakePage, fakeLimit)

            // Then
            if (result is Result.Failure) {
                result.throwable?.message shouldBe exception.message
            }
        }
    }

})