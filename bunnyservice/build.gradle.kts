import io.github.onlyashd.buildsrc.Sentry
import io.github.onlyashd.buildsrc.compileSdk
import io.github.onlyashd.buildsrc.getVersion
import io.github.onlyashd.buildsrc.minSdk
import io.github.onlyashd.buildsrc.targetSdk

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
    alias(libs.plugins.sentry)
}

android {
    namespace = "io.github.onlyashd.bunnyservice"
    compileSdk = project.compileSdk()

    defaultConfig {
        applicationId = "io.github.onlyashd.bunnyservice"
        minSdk = project.minSdk()
        targetSdk = project.targetSdk()
        versionCode = project.getVersion("service.versionCode").toInt()
        versionName = project.getVersion("service.versionName")

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        buildConfigField("String", "SENTRY_DSN", "\"${Sentry.SERVICE_DSN}\"")
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildFeatures {
        buildConfig = true
    }

    signingConfigs {
        create("release") {
            storeFile = file(System.getenv("RELEASE_STORE_FILE") ?: "dummy.keystore")
            storePassword = System.getenv("RELEASE_STORE_PASSWORD")
            keyAlias = System.getenv("RELEASE_KEY_ALIAS")
            keyPassword = System.getenv("RELEASE_KEY_PASSWORD")
        }
    }
}

dependencies {
    implementation(project(":shared"))
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.hilt)
    ksp(libs.hilt.compiler)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

sentry {
    org.set(Sentry.ORG)
    projectName.set("bunny-service")
    authToken.set(Sentry.AUTH_TOKEN)
    includeSourceContext.set(true)
}
