package com.didik.feature_watchlist.data.remote.response

import com.didik.feature_watchlist.helpers.Faker
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import io.mockk.spyk
import io.mockk.unmockkAll

class USDResponseTest : ShouldSpec({

    val faker = Faker
    val fakePrice = faker.numericalString
    val fakeChangePercentageDay = faker.numericalString
    lateinit var response: USDResponse

    beforeTest {
        response = spyk(
            USDResponse(
                price = fakePrice,
                changePercentageDay = fakeChangePercentageDay
            )
        )
    }

    afterTest {
        unmockkAll()
    }

    should("return correct values when injected") {
        with(response) {
            price shouldBe fakePrice
            changePercentageDay shouldBe fakeChangePercentageDay
        }
    }

})