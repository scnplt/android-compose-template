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
            implementationClass = "AnalysisConventionPlugin"
        }
        register("androidApplication") {
            id = libs.plugins.sc.android.application.asProvider().get().pluginId
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidComposeApplication") {
            id = libs.plugins.sc.android.application.compose.get().pluginId
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
    }
}
