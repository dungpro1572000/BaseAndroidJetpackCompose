plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.dungz.myapplication"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.dungz.myapplication"
        minSdk = 29
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug {
            isDebuggable = true
        }
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
//            signingConfig = signingConfigs.getByName("release")
        }
    }
    val TEST_BANNER_AD_UNIT = "ca-app-pub-3940256099942544/6300978111"
    val TEST_INTER_AD_UNIT = "ca-app-pub-3940256099942544/1033173712"
    val TEST_NATIVE_AD_UNIT = "ca-app-pub-3940256099942544/2247696110"
    val TEST_REWARD_AD_UNIT = "ca-app-pub-3940256099942544/5224354917"
    val TEST_NATIVE_FULLSCREEN_AD_UNIT = "ca-app-pub-3940256099942544/5354046379"
    flavorDimensions += "default"

    productFlavors {
        create("appDebug") {
            dimension = "default"
            manifestPlaceholders["app_id_admob"] = ""
            buildConfigField("String", "banner_ad_unit", TEST_BANNER_AD_UNIT)
            buildConfigField("String", "inter_ad_unit", TEST_INTER_AD_UNIT)
            buildConfigField("String", "native_ad_unit", TEST_NATIVE_AD_UNIT)
            buildConfigField("String", "reward_ad_unit", TEST_REWARD_AD_UNIT)
            buildConfigField("String", "native_fullscreen_ad_unit", TEST_NATIVE_FULLSCREEN_AD_UNIT)
        }
        create("appRelease") {
            dimension = "default"
            manifestPlaceholders["app_id_admob"] = ""
            buildConfigField("String", "banner_ad_unit", TEST_BANNER_AD_UNIT)
            buildConfigField("String", "inter_ad_unit", TEST_INTER_AD_UNIT)
            buildConfigField("String", "native_ad_unit", TEST_NATIVE_AD_UNIT)
            buildConfigField("String", "reward_ad_unit", TEST_REWARD_AD_UNIT)
            buildConfigField("String", "native_fullscreen_ad_unit", TEST_NATIVE_FULLSCREEN_AD_UNIT)
        }
    }

    signingConfigs {
        create("release") {
//            storeFile = file("key/release.jks")
//            storePassword = "trustedapp@123"
//            keyAlias = "release"
//            keyPassword = "trustedapp@123"
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.4"
    }
}
kotlin {
    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11)
    }
}

dependencies {
    // Module dependencies
    implementation(project(":data"))
    implementation(project(":domain"))

    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.room.paging)

    implementation(libs.androidx.work.runtime.ktx)
    implementation(libs.androidx.hilt.work)
    ksp(libs.androidx.hilt.compiler)

    implementation(libs.androidx.hilt.lifecycle.viewmodel.compose)
    implementation(libs.coil.compose)

    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.retrofit)
    implementation(libs.okhttp)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)

    // hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)
}