plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = 33
    defaultConfig {
        applicationId = "example.kmm.android"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.6.1")
    implementation("androidx.appcompat:appcompat:1.5.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
}