import com.android.build.api.dsl.ApplicationExtension
import dev.sertan.android.buildlogic.ApplicationConfig
import dev.sertan.android.buildlogic.configureAndroidCommon
import dev.sertan.android.buildlogic.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

internal class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project): Unit = with(target) {
        apply(plugin = "com.android.application")

        extensions.configure<ApplicationExtension> {
            configureAndroidCommon(this)

            defaultConfig {
                applicationId = namespace
                targetSdk = ApplicationConfig.TARGET_SDK
                versionCode = ApplicationConfig.VERSION_CODE
                versionName = ApplicationConfig.VERSION_NAME
            }

            buildTypes {
                getByName("release") {
                    isMinifyEnabled = true
                    isShrinkResources = true
                    proguardFiles(
                        getDefaultProguardFile("proguard-android-optimize.txt"),
                        "proguard-rules.pro"
                    )
                }
            }
        }

        dependencies {
            "implementation"(libs.findLibrary("androidx.core.ktx").get())
        }
    }
}
