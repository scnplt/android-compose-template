
import com.android.build.api.dsl.ApplicationExtension
import dev.sertan.android.buildlogic.ProjectConfig
import dev.sertan.android.buildlogic.configureAndroidCommon
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure

internal class AndroidApplicationPlugin : Plugin<Project> {
    override fun apply(target: Project): Unit = with(target) {
        apply(plugin = "com.android.application")

        extensions.configure<ApplicationExtension> {
            configureAndroidCommon(this)

            defaultConfig {
                applicationId = namespace
                targetSdk = ProjectConfig.TARGET_SDK
            }
        }
    }
}
