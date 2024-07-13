plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")

}
kotlin{
    jvmToolchain(11)
}
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(11)
    }
}
android {
    compileSdk = 34
    buildToolsVersion ="34.0.0"

    defaultConfig {
        applicationId = "com.example.behealthy3"
        minSdk = 23
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        buildToolsVersion ="34.0.0"
    }
    compileOptions {
        sourceCompatibility= JavaVersion.VERSION_1_8
        targetCompatibility =JavaVersion.VERSION_1_8
    }
    namespace = "com.example.behealthy3"
}

dependencies {
    implementation("org.tensorflow:tensorflow-lite:2.16.1")
    implementation("com.github.PhilJay:MPAndroidChart:v3.1.0")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.firebase:firebase-database:21.0.0")
    implementation("com.google.firebase:firebase-core:21.1.1")
    implementation("com.google.firebase:firebase-auth:23.0.0")
    implementation(platform("com.google.firebase:firebase-bom:33.1.1"))
    implementation("com.google.firebase:firebase-analytics:22.0.2")
    implementation(fileTree(mapOf("dir" to "libs","include" to listOf("*.jar"))))
    implementation(libs.media)
    implementation ("com.google.firebase:firebase-ml-model-interpreter:22.0.4")
    implementation ("org.tensorflow:tensorflow-lite:2.4.0")
    implementation ("com.google.firebase:firebase-ml-modeldownloader:22.0.4")

    testImplementation("junit:junit:4.13.2")
    implementation("androidx.activity:activity-ktx:1.7.2")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.8.0")
    implementation("androidx.core:core-ktx:1.10.0")
    implementation("com.github.PhilJay:MPAndroidChart:v3.1.0")
    implementation("com.google.android.material:material:1.8.0")



    implementation("com.google.android.gms:play-services-auth:20.1.0")


    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.activity:activity-ktx:1.7.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
apply(plugin = "com.google.gms.google-services")