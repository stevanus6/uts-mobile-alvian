plugins {
    alias(libs.plugins.android.application) // Menggunakan alias dari katalog pustaka untuk aplikasi Android
}

android {
    namespace = "com.example.infopariwisataapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.infopariwisataapp"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    // Jika menggunakan alias untuk pustaka, pastikan semua sudah terdefinisi di katalog pustaka libs.versions.toml
    implementation(libs.appcompat) // Pastikan libs.appcompat terdefinisi di katalog pustaka (libs.versions.toml)
    implementation(libs.material)  // Pastikan libs.material terdefinisi di katalog pustaka (libs.versions.toml)
    implementation(libs.activity)  // Pastikan libs.activity terdefinisi di katalog pustaka (libs.versions.toml)
    implementation(libs.constraintlayout) // Pastikan libs.constraintlayout terdefinisi di katalog pustaka (libs.versions.toml)

    // Dependensi manual jika alias tidak tersedia di katalog pustaka
    implementation("androidx.recyclerview:recyclerview:1.2.1")
    implementation("androidx.cardview:cardview:1.0.0")
    implementation("com.google.android.material:material:1.4.0")

    testImplementation(libs.junit) // Pastikan libs.junit terdefinisi di katalog pustaka (libs.versions.toml)
    androidTestImplementation(libs.ext.junit) // Pastikan libs.ext.junit terdefinisi di katalog pustaka (libs.versions.toml)
    androidTestImplementation(libs.espresso.core) // Pastikan libs.espresso.core terdefinisi di katalog pustaka (libs.versions.toml)
}
