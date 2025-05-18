import com.android.build.api.dsl.ApplicationExtension
import dev.sertan.android.buildlogic.configureCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.getByType

internal class AndroidApplicationComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project): Unit = with(target) {
        apply<AndroidApplicationConventionPlugin>()

        val extension = extensions.getByType<ApplicationExtension>()
        configureCompose(extension)
    }
}
