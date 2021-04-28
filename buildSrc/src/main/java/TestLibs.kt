internal object TestLibsVersion {
    const val jUnit = "4.13.2"
    const val jUnitExt = "1.1.2"
    const val espressoCore = "3.3.0"
    const val mockk = "1.11.0"
    const val kotest = "4.4.3"
}

object TestLibs {
    const val jUnit = "junit:junit:${TestLibsVersion.jUnit}"
    const val jUnitExt = "androidx.test.ext:junit:${TestLibsVersion.jUnitExt}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${TestLibsVersion.espressoCore}"
    const val mockk = "io.mockk:mockk:${TestLibsVersion.mockk}"
    const val kotestRunner = "io.kotest:kotest-runner-junit5:${TestLibsVersion.kotest}"
    const val kotestAssertions = "io.kotest:kotest-assertions-core:${TestLibsVersion.kotest}"
    const val kotestProperty = "io.kotest:kotest-property:${TestLibsVersion.kotest}"
}