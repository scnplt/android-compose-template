package dev.sertan.android.buildlogic

import org.gradle.api.JavaVersion
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

object ProjectConfig {
    const val MIN_SDK = 26
    const val COMPILE_SDK = 35
    const val TARGET_SDK = 35
    val JAVA_VERSION = JavaVersion.VERSION_11
    val JVM_TARGET = JvmTarget.JVM_11
}
