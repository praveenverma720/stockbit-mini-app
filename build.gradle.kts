buildscript {
    val kotlin_version by extra("1.4.32")
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
    dependencies {
        classpath(Libs.buildGradle)
        classpath(Libs.kotlinPlugin)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven { setUrl("https://jitpack.io") }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}