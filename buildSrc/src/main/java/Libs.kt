internal object LibsVersion {
    const val buildGradle = "4.2.0-alpha04"
    const val kotlin = "1.4.32"
    const val coreKtx = "1.3.2"
    const val appCompat = "1.2.0"
    const val material = "1.3.0"
    const val constraintLayout = "2.0.4"
    const val navigation = "2.3.5"
    const val lifecycleKtx = "2.3.1"
}

object Libs {
    const val buildGradle = "com.android.tools.build:gradle:${LibsVersion.buildGradle}"
    const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${LibsVersion.kotlin}"
    const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib:${LibsVersion.kotlin}"
    const val coreKtx = "androidx.core:core-ktx:${LibsVersion.coreKtx}"
    const val appCompat = "androidx.appcompat:appcompat:${LibsVersion.appCompat}"
    const val material = "com.google.android.material:material:${LibsVersion.material}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${LibsVersion.constraintLayout}"
    const val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:${LibsVersion.navigation}"
    const val navigationUIKtx = "androidx.navigation:navigation-ui-ktx:${LibsVersion.navigation}"
    const val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${LibsVersion.lifecycleKtx}"
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${LibsVersion.lifecycleKtx}"
}