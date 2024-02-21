import org.jetbrains.compose.ExperimentalComposeLibrary
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.kotlinxSerialization)
    // Required for moko-resources to work
//    alias(libs.plugins.mokoResources)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    jvm("desktop")

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    sourceSets {
        // Required for moko-resources to work
//        applyDefaultHierarchyTemplate()

        val desktopMain by getting

        androidMain {
            dependencies {
                implementation(libs.compose.ui.tooling.preview)
                implementation(libs.androidx.activity.compose)
                api(libs.koin.android)
                implementation(libs.kotlinx.coroutines.android)
//            implementation(libs.ktor.client.android)
                implementation(libs.ktor.client.okhttp)
            }

            // Required for moko-resources to work
//            dependsOn(commonMain.get())
        }

        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
            @OptIn(ExperimentalComposeLibrary::class)
            implementation(compose.components.resources)

            implementation(libs.kotlinx.coroutines.core)

            //di
            api(libs.koin.core)

            //sharedVm
            api(libs.kmm.viewmodel.core)

            //network
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.serialization.kotlinx.json)
            implementation(libs.ktor.client.json)
            implementation(libs.ktor.client.logging)

            implementation(libs.kotlinx.serialization.core)
            implementation(libs.kotlinx.datetime)

            //image loader
            implementation(libs.image.loader)

            //local
            implementation(libs.multiplatform.settings.no.arg)

            // Required for moko-resources to work
//            implementation(libs.moko.resources.compose)
        }
        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.ktor.client.jvm)
        }
        iosMain.dependencies {
//            implementation(libs.ktor.client.ios)
            implementation(libs.ktor.client.darwin)
        }
        commonTest.dependencies {
            implementation(kotlin("test-common"))
            implementation(kotlin("test-annotations-common"))
            implementation(libs.kotlinx.coroutines.test)
            implementation(libs.koin.test)
        }

        val androidInstrumentedTest by getting {
            dependencies {
                implementation(libs.androidx.ui.test.junit4.android)
                implementation(libs.androidx.ui.test.manifest)
            }
        }
    }
}

android {
    namespace = "com.maschago.multiplatformui"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        applicationId = "com.maschago.multiplatformui"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    dependencies {
        debugImplementation(libs.compose.ui.tooling)
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "com.maschago.multiplatformui"
            packageVersion = "1.0.0"
        }
    }
}

// Required for moko-resources to work
//multiplatformResources {
//    multiplatformResourcesPackage = "com.maschago.multiplatformui"
//}
