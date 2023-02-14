@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    // for testing
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.snsbrowser.domain"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }
}

dependencies {
    // Do not implement other modules from domain layer.

    /**
     * dependency inject
     * (Domain layer uses javax.inject instead of hilt.)
     */
    implementation(libs.javax.inject)

    /**
     * coroutines
     * (Do not implementation coroutines.android from domain layer.)
     */
    implementation(libs.kotlinx.coroutines.core)

    /**
     * test
     */
    testImplementation(project(":testing"))
}