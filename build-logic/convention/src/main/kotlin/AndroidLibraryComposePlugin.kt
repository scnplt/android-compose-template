import com.android.build.gradle.LibraryExtension
import dev.sertan.android.buildlogic.configureCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.getByType

internal class AndroidLibraryComposePlugin : Plugin<Project> {
    override fun apply(target: Project): Unit = with(target) {
        apply<AndroidLibraryPlugin>()

        val extension = extensions.getByType<LibraryExtension>()
        configureCompose(extension)
    }
}
