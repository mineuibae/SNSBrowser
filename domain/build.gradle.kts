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
     * paging
     * (Do not implementation paging.runtime from domain layer.
     * Because there is no android component in paging.common.)
     */
    implementation(libs.androidx.paging.common.ktx)

    /**
     * test
     */
    testImplementation(project(":testing"))
}