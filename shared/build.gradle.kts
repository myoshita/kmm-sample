import com.codingfeline.buildkonfig.compiler.FieldSpec.Type
import org.gradle.api.internal.artifacts.dependencies.DefaultExternalModuleDependency
import org.jetbrains.kotlin.konan.properties.loadProperties

plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    kotlin("kapt")
    kotlin("plugin.serialization") version libs.versions.kotlin.get()
    id("com.android.library")
    id("com.codingfeline.buildkonfig")
    id("com.google.dagger.hilt.android")
}

version = "1.0"

kotlin {
    android()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    explicitApiWarning()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.ktor.client.core)
                implementation(libs.kotlinx.coroutines.core)
                implementation(libs.kotlinx.serialization.json)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependsOn(commonMain)
            dependencies {
                implementation(libs.hilt.android)
                implementation(libs.ktor.client.okhttp)
            }
            configurations["kapt"].dependencies.add(
                libs.hilt.compiler.map {
                    DefaultExternalModuleDependency(
                        it.module.group,
                        it.module.name,
                        it.versionConstraint.requiredVersion,
                    )
                }.get()
            )
        }
        val androidTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

buildkonfig {
    packageName = "example.kmm"

    defaultConfigs {
        val apiKey = loadProperties("${project.rootDir.absolutePath}/local.properties")
            .getProperty("apiKey")
        buildConfigField(Type.STRING, "apiKey", apiKey)
        buildConfigField(Type.STRING, "apiUrl", "https://newsapi.org/v2")
    }
}

kapt {
    correctErrorTypes = true
}

android {
    compileSdk = 33
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 21
        targetSdk = 33
    }
}
