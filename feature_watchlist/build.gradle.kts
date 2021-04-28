plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    compileSdkVersion(AppConfig.compileSdkVersion)
    buildToolsVersion(AppConfig.buildToolsVersion)

    defaultConfig {
        minSdkVersion(AppConfig.minSdkVersion)
        targetSdkVersion(AppConfig.targetSdkVersion)
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName
        testInstrumentationRunner = AppConfig.testInstrumentationRunner
        consumerProguardFile("consumer-rules.pro")
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = AppConfig.jvmTarget
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(project(Modules.core))

    implementation(Libs.kotlinStdlib)
    implementation(Libs.appCompat)
    implementation(Libs.material)
    implementation(Libs.constraintLayout)
    implementation(Libs.fragmentKtx)
    implementation(Libs.recyclerView)
    implementation(Libs.paging)
    implementation(Libs.swipeRefreshLayout)
    implementation(Libs.lifecycleViewModel)
    implementation(Libs.lifecycleLiveData)
    implementation(Libs.moshi)
    implementation(Libs.retrofit)
    implementation(Libs.koinScope)
    implementation(Libs.koinFragment)
    implementation(Libs.koinViewModel)
    implementation(Libs.koinExt)

    testImplementation(TestLibs.mockk)
    testImplementation(TestLibs.kotestRunner)
    testImplementation(TestLibs.kotestAssertions)
    testImplementation(TestLibs.kotestProperty)
}