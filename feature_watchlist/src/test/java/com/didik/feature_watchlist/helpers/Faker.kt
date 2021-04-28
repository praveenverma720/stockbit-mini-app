package com.didik.feature_watchlist.helpers

import io.kotest.property.Arb
import io.kotest.property.arbitrary.*

interface IFaker {
    val string: String
    val numericalString: String
    val double: Double
    val int: Int
}

object Faker : IFaker {
    override val string: String = Arb.string().next()
    override val numericalString: String = Arb.numericDoubles().next().toString()
    override val double: Double = Arb.double().next()
    override val int: Int = Arb.int().next()
}