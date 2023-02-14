@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.hilt.android)
    alias(libs.plugins.kotlin.kapt)
}

android {
    namespace = "com.example.snsbrowser.testing"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }
}

dependencies {
    implementation(project(":domain"))

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    api(libs.junit)
    api(libs.androidx.test.ext.junit)
    api(libs.androidx.test.espresso.core)
    api(libs.androidx.test.core.ktx)
    api(libs.androidx.test.runner)
    api(libs.hilt.android.test)
    api(libs.kotlin.test)
    api(libs.kotlin.coroutines.test)
    api(libs.turbine)
}