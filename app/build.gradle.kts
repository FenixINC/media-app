plugins {
    id(BuildPlugin.android_application)
    id(BuildPlugin.google_services)
    id(BuildPlugin.github_ben_manes)
    id(BuildPlugin.kotlin_android)
    id(BuildPlugin.kotlin_android_extensions)
    id(BuildPlugin.kotlin_kapt)
    id(BuildPlugin.apollo_graphql_plugin)

//    kotlin("multiplatform") version "1.3.70"
    kotlin("plugin.serialization") version Version.kotlin_version
}

android {
    compileSdkVersion(AndroidSdk.compile_sdk_version)

    defaultConfig {
        applicationId = AndroidSdk.application_id
        minSdkVersion(AndroidSdk.min_sdk_version)
        targetSdkVersion(AndroidSdk.target_sdk_version)
        versionCode = AndroidSdk.version_code
        versionName = AndroidSdk.version_name
        testInstrumentationRunner = AndroidSdk.test_instrumentation_runner

        buildConfigField("String", "API_BASE_URL", "\"https://newsapi.org/\"")
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

    dataBinding {
        isEnabled = true
    }

    androidExtensions {
        isExperimental = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    (this as ExtensionAware).configure<org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions> {
        jvmTarget = "1.8"
    }

    packagingOptions {
        exclude("META-INF/*.kotlin_module")
    }

//    apollo {
//        generateKotlinModels.set(true)
//    }
}

repositories {
    jcenter()
}

dependencies {
    // Material
    implementation(Library.material_lib)

    // Androidx
    implementation(Library.core_ktx_lib)
    implementation(Library.activity_ktx_lib)
    implementation(Library.fragment_ktx_lib)
    implementation(Library.appcompat_lib)
    implementation(Library.cardview_lib)
    implementation(Library.browser_lib)
    implementation(Library.recyclerview_lib)
    implementation(Library.constraint_layout_lib)
    implementation(Library.swiperefresh_lib)
    implementation(Library.viewpager2_lib)

    // Retrofit
    implementation(Library.retrofit_lib)
    implementation(Library.converter_gson_lib)

    // Kotlin
    implementation(Library.kotlin_lib)

    // Kotlin Coroutines
    implementation(Library.kotlin_coroutines_core_lib)
    implementation(Library.kotlin_coroutines_android_lib)

    // Kotlin Serialization
    implementation(Library.kotlin_serialization_lib)
    implementation(Library.kotlin_serialization_converter_lib)

    // OkHttp
    implementation(Library.okhttp_lib)
    implementation(Library.okhttp_interceptor_lib)

    // Glide
    implementation(Library.glide_lib)
    implementation(Library.glide_okhttp_lib)
    implementation(Library.glide_transformations_lib)

    // Coil
    implementation(Library.coil_lib)

    // Room:
    implementation(Library.room_ktx_lib)
    implementation(Library.room_runtime_lib)
    kapt(Library.room_runtime_lib)

    // Lifecycle:
    implementation(Library.lifecycle_extensions_lib)
    implementation(Library.lifecycle_common_java8_lib)
    // kapt (Library.lifecycle_compiler_lib)
    implementation(Library.lifecycle_runtime_ktx_lib)
    implementation(Library.viewmodel_ktx_lib)
    implementation(Library.livedata_ktx_lib)

    // Navigation
    implementation(Library.navigation_fragment_ktx_lib)
    implementation(Library.navigation_ui_ktx_lib)

    // Koin
    implementation(Library.koin_core_lib)
    implementation(Library.koin_android_scope_lib)
    implementation(Library.koin_android_viewmodel_lib)

    // GraphQL
    implementation(Library.apollo_graphql_lib)
//    compileOnly 'org.jetbrains:annotations:16.0.1'
//    testCompileOnly 'org.jetbrains:annotations:16.0.1'

    // Ktor
    implementation(Library.ktor_android_lib)
    implementation(Library.ktor_json_jvm_lib)
    implementation(Library.ktor_serialization_lib)
    implementation(Library.ktor_gson_lib)
//    implementation "io.ktor:ktor-client-cio:$ktor_version"
    // Ktor JVM (necessary for logging extension)
    implementation(Library.ktor_logging_jvm_lib)
    // Ktor Logging extension
    implementation(Library.ktor_logging)
    // Necessary to show logs in logcat
    implementation(Library.logback_lib)

    // Timber
    implementation(Library.timber_lib)

    // Stetho
    implementation(Library.stetho_lib)

    // Recyclerview animators
    implementation(Library.recyclerview_animators_lib)

    // Firebase
    implementation(Library.android_gms_play_services_lib)
    implementation(Library.firebase_auth_lib)
    implementation(Library.firebase_firestore_lib)
    implementation(Library.firebase_storage_lib)
    implementation(Library.firebase_ktx_lib)
    implementation(Library.coroutines_play_services_lb)
//    implementation(Library.google_guava_lib)
//    implementation(Library.firebase_inappmessaging_lib)
    implementation(Library.guava_conflict)

    // Test
    testImplementation(Library.koin_test_lib)
    testImplementation(Library.junit_lib)
    androidTestImplementation(Library.test_runner_lib)
    androidTestImplementation(Library.espresso_lib)
}