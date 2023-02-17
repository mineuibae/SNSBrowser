@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.hilt.android)
    alias(libs.plugins.kotlin.kapt)
}

android {
    namespace = "com.example.snsbrowser.feature.search"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
        testInstrumentationRunner = "com.example.snsbrowser.testing.HiltTestRunner"
    }

    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    /**
     * other modules
     */
    implementation(project(":common"))
    implementation(project(":domain"))
    implementation(project(":ui"))

    /**
     * androidx
     */
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    /**
     * google
     */
    implementation(libs.material)

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
     * paging
     */
    implementation(libs.androidx.paging.runtime.ktx)

    /**
     * coil
     */
    implementation(libs.coil.kt)
    implementation(libs.coil.svg)

    /**
     * test
     */
    testImplementation(project(":testing"))
    androidTestImplementation(project(":testing"))
    kaptAndroidTest(libs.hilt.android.compiler)
}