package com.didik.feature_watchlist.data.remote.response

import com.didik.feature_watchlist.helpers.Faker
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import io.mockk.spyk
import io.mockk.unmockkAll

class CoinInfoResponseTest : ShouldSpec({

    val faker = Faker
    val fakeId = faker.string
    val fakeName = faker.string
    val fakeFullName = faker.string
    lateinit var response: CoinInfoResponse

    beforeTest {
        response = spyk(
            CoinInfoResponse(
                id = fakeId,
                name = fakeName,
                fullName = fakeFullName
            )
        )
    }

    afterTest {
        unmockkAll()
    }

    should("return correct values when injected") {
        with(response) {
            id shouldBe fakeId
            name shouldBe fakeName
            fullName shouldBe fakeFullName
        }
    }

})