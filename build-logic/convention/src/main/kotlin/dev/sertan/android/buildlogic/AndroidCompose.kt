package dev.sertan.android.buildlogic

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureCompose(commonExtension: CommonExtension<*, *, *, *, *, *>) {
    apply(plugin = "org.jetbrains.kotlin.plugin.compose")

    commonExtension.apply {
        buildFeatures {
            compose = true
        }
    }

    dependencies {
        val composeBom = libs.findLibrary("androidx.compose.bom").get()
        "implementation"(platform(composeBom))
        "androidTestImplementation"(platform(composeBom))

        // Android Studio Preview support
        "implementation"(libs.findLibrary("androidx.ui.tooling.preview").get())
        "debugImplementation"(libs.findLibrary("androidx.ui.tooling").get())
    }
}
