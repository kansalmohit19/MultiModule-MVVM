// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.dagger) apply false
    alias(libs.plugins.ktlint) apply false
    alias(libs.plugins.detekt) apply false
}

subprojects {
    plugins.withId("org.jlleitschuh.gradle.ktlint") {

        // Make preBuild depend on ktlintCheck
        tasks.named("preBuild") {
            dependsOn("ktlintCheck")
        }

        // Configure ktlint options
        extensions.configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
            version.set("0.48.2")
            android.set(true)
            outputColorName.set("RED")
            ignoreFailures.set(false)
            reporters {
                reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.PLAIN)
                reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.CHECKSTYLE)
            }
            filter {
                exclude("**/generated/**")
                include("**/kotlin/**")
            }
        }
    }

    plugins.withId("io.gitlab.arturbosch.detekt") {

        // Make preBuild depend on detekt
        tasks.named("preBuild") {
            dependsOn("detekt")
        }

        // Configure detekt options
        extensions.configure<io.gitlab.arturbosch.detekt.extensions.DetektExtension> {
            toolVersion = "1.23.6"
            buildUponDefaultConfig = true
            allRules = false
            parallel = true
        }
    }
}
tasks.register("installGitHooks") {
    doLast {
        val hooksDir = file("${project.rootDir}/.git/hooks")
        val sourceHook = file("${project.rootDir}/scripts/pre-push")
        val targetHook = File(hooksDir, "pre-push")

        if (!hooksDir.exists()) hooksDir.mkdirs()
        sourceHook.copyTo(targetHook, overwrite = true)
        targetHook.setExecutable(true)

        println("Git hooks installed successfully.")
    }
}