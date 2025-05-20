package dev.sertan.android.buildlogic

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureCompose(commonExtension: CommonExtension<*, *, *, *, *, *>) {
    apply(plugin = "org.jetbrains.kotlin.plugin.compose")

    commonExtension.buildFeatures.compose = true

    dependencies {
        val composeBom = getLibrary("androidx.compose.bom")
        "implementation"(platform(composeBom))
        "androidTestImplementation"(platform(composeBom))

        // Android Studio Preview support
        "implementation"(getLibrary("androidx.ui.tooling.preview"))
        "debugImplementation"(getLibrary("androidx.ui.tooling"))
    }
}
