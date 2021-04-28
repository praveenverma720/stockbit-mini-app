package com.didik.feature_watchlist.domain.repository

import com.didik.core.data.Result
import com.didik.feature_watchlist.domain.model.CryptoModel
import com.didik.feature_watchlist.helpers.Faker
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.unmockkAll

class IStockRepositoryTest : ShouldSpec({

    val faker = Faker
    lateinit var repository: IStockRepository

    beforeTest {
        repository = mockk()
    }

    afterTest {
        unmockkAll()
    }

    context("get top crypto") {
        should("return result crypto model list") {
            // Given
            val fakePage = faker.int
            val fakeLimit = faker.int
            val fakeResult: Result<List<CryptoModel>> = mockk()

            coEvery { repository.getTopCrypto(fakePage, fakeLimit) } returns fakeResult

            // When
            val result = repository.getTopCrypto(fakePage, fakeLimit)

            // Then
            result shouldBe fakeResult
        }
    }

})