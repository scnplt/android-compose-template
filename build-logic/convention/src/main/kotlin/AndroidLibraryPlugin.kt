
import com.android.build.gradle.LibraryExtension
import dev.sertan.android.buildlogic.configureAndroidCommon
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.getByType

internal class AndroidLibraryPlugin : Plugin<Project> {
    override fun apply(target: Project): Unit = with(target) {
        apply(plugin = "com.android.library")

        val extension = extensions.getByType<LibraryExtension>()
        configureAndroidCommon(extension)
    }
}
