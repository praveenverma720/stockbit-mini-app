package com.didik.feature_watchlist.data.remote.response

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.unmockkAll

class CoinDisplayResponseTest : ShouldSpec({

    val fakeUSD: USDResponse = mockk()
    lateinit var response: CoinDisplayResponse

    beforeTest {
        response = spyk(CoinDisplayResponse(fakeUSD))
    }

    afterTest {
        unmockkAll()
    }

    should("return usd should be correct when injected") {
        response.usd shouldBe fakeUSD
    }

})