plugins {
    `kotlin-dsl`
}

group = "dev.sertan.android.buildlogic"

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

tasks {
    validatePlugins {
        enableStricterValidation = true
        failOnWarning = true
    }
}

gradlePlugin {
    plugins {
        register("analysis") {
            id = libs.plugins.sc.analysis.get().pluginId
            implementationClass = "AnalysisPlugin"
        }
        register("androidApplication") {
            id = libs.plugins.sc.android.application.asProvider().get().pluginId
            implementationClass = "AndroidApplicationPlugin"
        }
        register("androidComposeApplication") {
            id = libs.plugins.sc.android.application.compose.get().pluginId
            implementationClass = "AndroidApplicationComposePlugin"
        }
        register("androidFeature") {
            id = libs.plugins.sc.android.feature.compose.get().pluginId
            implementationClass = "AndroidFeatureComposePlugin"
        }
        register("androidLibrary") {
            id = libs.plugins.sc.android.library.asProvider().get().pluginId
            implementationClass = "AndroidLibraryPlugin"
        }
        register("androidLibraryCompose") {
            id = libs.plugins.sc.android.library.compose.get().pluginId
            implementationClass = "AndroidLibraryComposePlugin"
        }
        register("hilt") {
            id = libs.plugins.sc.hilt.get().pluginId
            implementationClass = "HiltPlugin"
        }
    }
}
