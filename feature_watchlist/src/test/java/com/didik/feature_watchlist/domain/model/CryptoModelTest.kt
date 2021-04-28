package com.didik.feature_watchlist.domain.model

import com.didik.feature_watchlist.helpers.Faker
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import io.mockk.spyk
import io.mockk.unmockkAll

class CryptoModelTest : ShouldSpec({

    val faker = Faker
    val fakeId = faker.string
    val fakeName = faker.string
    val fakeFullName = faker.string
    val fakePrice = faker.numericalString
    val fakeChangePercentageDay = faker.double
    lateinit var model: CryptoModel

    beforeTest {
        model = spyk(
            CryptoModel(
                id = fakeId,
                name = fakeName,
                fullName = fakeFullName,
                price = fakePrice,
                changePercentageDay = fakeChangePercentageDay
            )
        )
    }

    afterTest {
        unmockkAll()
    }

    should("return crypto model correctly when injected") {
        with(model) {
            id shouldBe fakeId
            name shouldBe fakeName
            fullName shouldBe fakeFullName
            price shouldBe fakePrice
            changePercentageDay shouldBe fakeChangePercentageDay
        }
    }

})