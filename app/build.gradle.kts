import dev.sertan.android.buildlogic.ApplicationConfig

plugins {
    alias(libs.plugins.sc.android.application.compose)
}

android {
    namespace = ApplicationConfig.APP_PACKAGE_ID
}

dependencies {
    implementation(libs.androidx.lifecycle.runtime.ktx)

    implementation(libs.androidx.material3)
    implementation(libs.androidx.activity.compose)

    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.test.manifest)
}
