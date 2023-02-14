@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.hilt.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.example.snsbrowser.data.youtube"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }

    buildFeatures {
        buildConfig = true
    }

    defaultConfig {
        buildConfigField("String", "API_KEY", "\"AIzaSyBEuSoFz_Zibu6MjuNe8he7YzhKmuv6csg\"")
        buildConfigField("String", "BASE_URL", "\"https://www.googleapis.com/youtube/v3/\"")
    }
}

dependencies {
    /**
     * other modules
     */
    implementation(project(":common"))
    implementation(project(":domain"))

    /**
     * dependency inject
     */
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    /**
     * coroutines
     */
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    /**
     * serialization
     */
    implementation(libs.kotlinx.serialization.json)

    /**
     * retrofit
     */
    implementation(libs.retrofit)
    implementation(libs.retrofit.kotlinx.serialization.converter)

    /**
     * test
     */
    testImplementation(project(":testing"))
}