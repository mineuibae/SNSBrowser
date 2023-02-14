@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.hilt.android)
    alias(libs.plugins.kotlin.kapt)
}

android {
    namespace = "com.example.snsbrowser.common"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }
}

dependencies {
    // Do not implement other modules from common module.

    /**
     * dependency inject
     */
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    /**
     * coroutines
     */
    implementation(libs.kotlinx.coroutines.core)

    testImplementation(project(":testing"))
}