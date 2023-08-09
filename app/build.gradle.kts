//plugins {
//    id 'com.android.application'
//    id 'org.jetbrains.kotlin.android'
//}
//
//android {
//    namespace 'com.example.mysportsapp'
//    compileSdk 33
//
//    defaultConfig {
//        applicationId "com.example.mysportsapp"
//        minSdk 24
//        targetSdk 33
//        versionCode 1
//        versionName "1.0"
//
//        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
//        vectorDrawables {
//            useSupportLibrary true
//        }
//    }
//
//    buildTypes {
//        release {
//            minifyEnabled false
//            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
//        }
//    }
//    compileOptions {
//        sourceCompatibility JavaVersion.VERSION_1_8
//        targetCompatibility JavaVersion.VERSION_1_8
//    }
//    kotlinOptions {
//        jvmTarget = '1.8'
//    }
//    buildFeatures {
//        compose true
//    }
//    composeOptions {
//        kotlinCompilerExtensionVersion '1.3.2'
//    }
//    packagingOptions {
//        resources {
//            excludes += '/META-INF/{AL2.0,LGPL2.1}'
//        }
//    }
//}
//
//dependencies {
//
//    implementation 'androidx.core:core-ktx:1.8.0'
//    implementation 'androidx.lifecycle:lifecycle-runtime-ktx:2.3.1'
//    implementation 'androidx.activity:activity-compose:1.5.1'
//    implementation platform('androidx.compose:compose-bom:2022.10.00')
//    implementation 'androidx.compose.ui:ui'
//    implementation 'androidx.compose.ui:ui-graphics'
//    implementation 'androidx.compose.ui:ui-tooling-preview'
//    implementation 'androidx.compose.material3:material3'
//    testImplementation 'junit:junit:4.13.2'
//    androidTestImplementation 'androidx.test.ext:junit:1.1.5'
//    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'
//    androidTestImplementation platform('androidx.compose:compose-bom:2022.10.00')
//    androidTestImplementation 'androidx.compose.ui:ui-test-junit4'
//    debugImplementation 'androidx.compose.ui:ui-tooling'
//    debugImplementation 'androidx.compose.ui:ui-test-manifest'
//}


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
//    implementation(platform("androidx.compose:compose-bom:2022.10.00"))
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



