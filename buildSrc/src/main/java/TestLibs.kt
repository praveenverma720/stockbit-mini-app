internal object TestLibsVersion {
    const val mockk = "1.11.0"
    const val kotest = "4.4.3"
}

object TestLibs {
    const val mockk = "io.mockk:mockk:${TestLibsVersion.mockk}"
    const val kotestRunner = "io.kotest:kotest-runner-junit5:${TestLibsVersion.kotest}"
    const val kotestAssertions = "io.kotest:kotest-assertions-core:${TestLibsVersion.kotest}"
    const val kotestProperty = "io.kotest:kotest-property:${TestLibsVersion.kotest}"
}