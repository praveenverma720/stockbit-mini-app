internal object TestLibsVersion {
    const val jUnit = "4.13.2"
    const val jUnitExt = "1.1.2"
    const val espressoCore = "3.3.0"
}

object TestLibs {
    const val jUnit = "junit:junit:${TestLibsVersion.jUnit}"
    const val jUnitExt = "androidx.test.ext:junit:${TestLibsVersion.jUnitExt}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${TestLibsVersion.espressoCore}"
}