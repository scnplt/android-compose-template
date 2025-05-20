import dev.sertan.android.buildlogic.getLibrary
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.dependencies

internal class AndroidFeatureComposePlugin : Plugin<Project> {
    override fun apply(target: Project): Unit = with(target) {
        apply<AndroidLibraryComposePlugin>()
        apply<HiltPlugin>()
        apply(plugin = "org.jetbrains.kotlin.plugin.serialization")

        dependencies {
            "implementation"(getLibrary("androidx.hilt.navigation.compose"))
            "implementation"(getLibrary("androidx.material3"))
            "implementation"(getLibrary("androidx.navigation.compose"))
            "implementation"(getLibrary("kotlinx.serialization.json"))
        }
    }
}
