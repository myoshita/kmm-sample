buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath(libs.kotlin.gradlePlugin)
        classpath(libs.android.gradlePlugin)
        classpath(libs.buildKonfig.gradlePlugin)
        classpath(libs.hilt.gradlePlugin)
    }
}

plugins {
    kotlin("native.cocoapods") version libs.versions.kotlin.get()
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}