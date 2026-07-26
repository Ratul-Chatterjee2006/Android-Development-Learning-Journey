plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.api"
    compileSdk=37

    defaultConfig {
        applicationId = "com.example.api"
        minSdk = 27
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }

    buildFeatures {
        viewBinding=true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.fragment)
    implementation(libs.androidx.recyclerview)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)

    //add retrofit dependency
    implementation("com.squareup.retrofit2:retrofit:3.0.0")

    //gson
    implementation("com.squareup.retrofit2:converter-gson:3.0.0")
    //picaso library for loading image in my imageview
    implementation("com.squareup.picasso:picasso:2.8")
}