plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("plugin.serialization")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}



android {
    val compile = extra["android.compileSdk"] as String
    val target = extra["android.targetSdk"] as String
    val min = extra["android.minSdk"] as String
    val composeCompiler = extra["compose.compiler"] as String


    namespace = "com.example.mysportsapp"
    compileSdk = compile.toInt()

    defaultConfig {
        applicationId = "com.example.mysportsapp"
        minSdk = min.toInt()
        targetSdk = target.toInt()
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = composeCompiler
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    kapt {
        correctErrorTypes = true
    }
}

dependencies {
    implementation(libs.bundles.core)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.bundles.compose)

    // Retrofit
    implementation(libs.bundles.network)

    // Dagger-Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.complier)

    //Coil For image loading
    implementation(libs.androidx.coil)

    //Testing
    testImplementation(libs.bundles.test)
}



