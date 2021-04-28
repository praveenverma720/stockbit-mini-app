package com.didik.feature_watchlist.data.remote.response

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.unmockkAll

class CryptoResponseTest : ShouldSpec({

    val fakeData: List<CryptoDataResponse> = mockk()
    lateinit var response: CryptoResponse

    beforeTest {
        response = spyk(CryptoResponse(fakeData))
    }

    afterTest {
        unmockkAll()
    }

    should("return data should be correct when injected") {
        response.data shouldBe fakeData
    }

})