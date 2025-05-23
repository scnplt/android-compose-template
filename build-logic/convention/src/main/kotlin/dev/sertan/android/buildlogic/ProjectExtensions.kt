package dev.sertan.android.buildlogic

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

internal fun Project.getLibrary(alias: String) =
    extensions.getByType<VersionCatalogsExtension>().named("libs").findLibrary(alias).get()

internal val Project.reportsFolder: String
    get() = "$rootDir/reports"
