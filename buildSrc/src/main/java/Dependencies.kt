/**
 * Contains gradle plugins
 * */
object Plugins {
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "android"
    const val kotlinExtensions = "android.extensions"
    const val kapt = "kapt"
}

object Versions {
    const val sdp = "1.0.6"
    const val ssp = "1.0.6"
    // kotlin
    const val kotlin = "1.3.31"
    const val ktx = "1.0.0"
    const val anko = "0.10.8"
    const val kotlinCoroutines = "1.1.1"

    const val okHttp = "3.12.0"
    const val timber = "4.7.1"

    // arch
    const val archVersion = "2.0.0"

    // retrofit
    const val gsonConverter = "2.5.0"

    const val koin = "2.0.1"
}

object Configs {
    const val applicationId = "com.shweta.mvvmkoindemo"
    const val compileSdkVersion = 28
    const val minSdkVersion = 21
    const val targetSdkVersion = 28
    const val versionCode = 1
    const val versionName = "1.0"
}

object Libraries {
    object Kotlin {
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutines}"
        const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinCoroutines}"
        const val ktxCore = "androidx.core:core-ktx:${Versions.ktx}"
        const val sdp = "com.intuit.sdp:sdp-android:1.0.6"
        const val anko = "org.jetbrains.anko:anko-support-v4-commons:${Versions.anko}"
    }

    /**
     * Contains androidx dependencies
     * */
    object Androidx {
        const val coreKtx = "androidx.core:core-ktx:1.0.0"
        const val appcompat = "androidx.appcompat:appcompat:1.1.0-alpha01"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:1.1.3"
    }

    object Android {
        const val design = "com.google.android.material:material:1.0.0"
        const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    }

    object Koin {
        const val viewmodel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"
        const val android = "org.koin:koin-android:${Versions.koin}"
        const val scope = "org.koin:koin-androidx-scope:${Versions.koin}"
        //const val scope = "org.koin:koin-android-scope:2.0.0-rc-1"
    }

    object Retrofit {
        const val retrofit = "com.squareup.retrofit2:retrofit:2.5.0"
        const val coroutineAdapter = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2"
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.gsonConverter}"
        const val okHttp3 = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
        const val okHttp3Intercepter = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
    }

    object Tests {
        val junit = "junit:junit:4.12"
    }

    object AndroidTests {
        val testRunner = "androidx.test:runner:1.1.2-alpha01"
        val espressoCore = "androidx.test.espresso:espresso-core:3.1.2-alpha01"
    }

    const val glide = "com.github.bumptech.glide:glide:4.8.0"
    const val glideProcessor = "com.github.bumptech.glide:compiler:4.8.0"
}

object Arch {

    /**
     * Contains LifeCycle related dependencies
     * */
    object Lifecycle {
        const val extensions = "androidx.lifecycle:lifecycle-extensions:${Versions.archVersion}"
    }
}
