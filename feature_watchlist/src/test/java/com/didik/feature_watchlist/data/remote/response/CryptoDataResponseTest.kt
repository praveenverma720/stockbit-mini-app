package com.didik.feature_watchlist.data.remote.response

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.unmockkAll

class CryptoDataResponseTest : ShouldSpec({

    val fakeCoinInfo: CoinInfoResponse = mockk()
    val fakeDisplay: CoinDisplayResponse = mockk()
    lateinit var response: CryptoDataResponse

    beforeTest {
        response = spyk(
            CryptoDataResponse(
                coinInfo = fakeCoinInfo,
                display = fakeDisplay
            )
        )
    }

    afterTest {
        unmockkAll()
    }

    should("return correct values when injected") {
        with(response) {
            coinInfo shouldBe fakeCoinInfo
            display shouldBe fakeDisplay
        }
    }

})