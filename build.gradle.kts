// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.dagger) apply false
    alias(libs.plugins.ktlint) apply false
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
}