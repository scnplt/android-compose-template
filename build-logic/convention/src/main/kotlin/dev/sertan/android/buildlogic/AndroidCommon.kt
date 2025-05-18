package dev.sertan.android.buildlogic

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.assign
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension

internal fun Project.configureAndroidCommon(commonExtension: CommonExtension<*, *, *, *, *, *>) {
    apply(plugin = "org.jetbrains.kotlin.android")

    commonExtension.apply {
        compileSdk = ApplicationConfig.COMPILE_SDK

        defaultConfig {
            minSdk = ApplicationConfig.MIN_SDK
            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }

        compileOptions {
            sourceCompatibility = ApplicationConfig.JAVA_VERSION
            targetCompatibility = ApplicationConfig.JAVA_VERSION
        }

        configure<KotlinAndroidProjectExtension> {
            compilerOptions.jvmTarget = ApplicationConfig.JVM_TARGET
        }
    }
}
