plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(29)
    buildToolsVersion = "29.0.2"

    defaultConfig {
        applicationId = "com.lance.baseassigment"
        minSdkVersion(23)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
}

dependencies {
    implementation(fileTree("dir" to "libs", "include" to listOf("*.jar")))

    implementation(Dependencies.Kotlin.core)
    implementation(Dependencies.Kotlin.extension)
    implementation(Dependencies.Android.appCompact)
    implementation(Dependencies.ReactivePrograming.RxJava)
    implementation(Dependencies.Network.retrofit)

    implementation(Dependencies.Database.Room.core)
    implementation(Dependencies.Database.Room.kotlin_extension)
    implementation(Dependencies.Database.Room.rxjava)
    kapt(Dependencies.Database.Room.compiler)

    implementation(Dependencies.ImageLoader.glide)

    testImplementation(Dependencies.Test.junit)

    androidTestImplementation(Dependencies.AndroidTests.junit)
    androidTestImplementation(Dependencies.AndroidTests.espresso)
}
