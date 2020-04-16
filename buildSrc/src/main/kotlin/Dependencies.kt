object AndroidSdk {
    const val application_id                                 = "com.example.media_app"

    const val min_sdk_version                                = 21
    const val target_sdk_version                             = 28
    const val compile_sdk_version                            = 28

    const val version_code                                   = 1
    const val version_name                                   = "1.0"

    const val test_instrumentation_runner                    = "androidx.test.runner.AndroidJUnitRunner"
}

object BuildPlugin {
    const val apollo_graphql_plugin                          = "com.apollographql.apollo"
    const val github_ben_manes                               = "com.github.ben-manes.versions"
    const val android_application                            = "com.android.application"
    const val google_services                                = "com.google.gms.google-services"
    const val kotlin_android                                 = "kotlin-android"
    const val kotlin_android_extensions                      = "kotlin-android-extensions"
    const val kotlin_kapt                                    = "kotlin-kapt"
    const val kotlinx_serialization                          = "kotlinx-serialization"
}

object Version {
    // Plugins
    const val gradle_plugin_version                          = "3.6.2"
    const val kotlin_plugin_version                          = "1.3.71"
    const val apollo_graphql_plugin_version                  = "1.3.3"
    const val github_ben_means_plugin_version                = "0.22.0"
    const val google_services_version                        = "4.3.3"

    // Material
    const val material_version                               = "1.2.0-alpha05"

    // Androidx
    const val core_ktx_version                               = "1.3.0-beta01"
    const val activity_ktx_version                           = "1.1.0"
    const val fragment_ktx_version                           = "1.2.4"
    const val appcompat_version                              = "1.1.0"
    const val cardview_version                               = "1.0.0"
    const val browser_version                                = "1.2.0"
    const val recyclerview_version                           = "1.2.0-alpha02"
    const val constraint_layout_version                      = "2.0.0-beta4"
    const val swiperefresh_layout_version                    = "1.0.0"
    const val viewpager2_version                             = "1.0.0"

    // Retrofit
    const val retrofit_version                               = "2.7.0"

    // Kotlin
    const val kotlin_version                                 = "1.3.71"

    // Kotlin Coroutines
    const val kotlin_coroutines_version                      = "1.3.3"

    // Kotlin Serialization
    const val kotlin_serialization_version                   = "0.20.0"
    const val kotlin_serialization_converter_version         = "0.5.0"

    // OkHttp
    const val okhttp_version                                 = "4.4.0"

    // Glide
    const val glide_version                                  = "4.11.0"
    const val glide_transformations_version                  = "4.1.0"

    // Coil
    const val coil_version                                   = "0.9.5"

    // Room
    const val room_version                                   = "2.2.5"

    // Lifecycle
    const val lifecycle_version                              = "2.2.0"

    // Navigation
    const val navigation_version                             = "2.2.2"

    // Koin
    const val koin_version                                   = "2.1.5"

    // GraphQL
    const val apollo_graphql_version                         = "1.3.3"

    // Ktor
    const val ktor_version                                   = "1.3.2"

    // Logback for Ktor
    const val logback_version                                = "1.2.3"

    // Timber
    const val timber_version                                 = "4.7.1"

    // Stetho
    const val stetho_version                                 = "1.5.1"

    // Recyclerview animators
    const val recyclerview_animators_version                 = "2.3.0"

    // Firebase
    const val firebase_auth_version                          = "19.3.0"
    const val android_gms_play_services                      = "18.0.0"

    // Test
    const val koin_test_version                              = "2.0.0"
    const val junit_version                                  = "4.12"
    const val test_runner_version                            = "1.2.0"
    const val espresso_version                               = "3.2.0"
}

object Library {
    // Material
    const val material_lib                                   = "com.google.android.material:material:${Version.material_version}"

    // Androidx
    const val core_ktx_lib                                   = "androidx.core:core-ktx:${Version.core_ktx_version}"
    const val activity_ktx_lib                               = "androidx.activity:activity-ktx:${Version.activity_ktx_version}"
    const val fragment_ktx_lib                               = "androidx.fragment:fragment-ktx:${Version.fragment_ktx_version}"
    const val appcompat_lib                                  = "androidx.appcompat:appcompat:${Version.appcompat_version}"
    const val cardview_lib                                   = "androidx.cardview:cardview:${Version.cardview_version}"
    const val browser_lib                                    = "androidx.browser:browser:${Version.browser_version}"
    const val recyclerview_lib                               = "androidx.recyclerview:recyclerview:${Version.recyclerview_version}"
    const val constraint_layout_lib                          = "androidx.constraintlayout:constraintlayout:${Version.constraint_layout_version}"
    const val swiperefresh_lib                               = "androidx.swiperefreshlayout:swiperefreshlayout:${Version.swiperefresh_layout_version}"
    const val viewpager2_lib                                 = "androidx.viewpager2:viewpager2:${Version.viewpager2_version}"

    // Retrofit
    const val retrofit_lib                                   = "com.squareup.retrofit2:retrofit:${Version.retrofit_version}"
    const val converter_gson_lib                             = "com.squareup.retrofit2:converter-gson:${Version.retrofit_version}"

    // Kotlin
    const val kotlin_lib                                     = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Version.kotlin_version}"

    // Kotlin Coroutines
    const val kotlin_coroutines_core_lib                     = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.kotlin_coroutines_version}"
    const val kotlin_coroutines_android_lib                  = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.kotlin_coroutines_version}"

    // Kotlin Serialization
    const val kotlin_serialization_lib                       = "org.jetbrains.kotlinx:kotlinx-serialization-runtime:${Version.kotlin_serialization_version}"
    const val kotlin_serialization_converter_lib             = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Version.kotlin_serialization_converter_version}"

    // OkHttp
    const val okhttp_lib                                     = "com.squareup.okhttp3:okhttp:${Version.okhttp_version}"
    const val okhttp_interceptor_lib                         = "com.squareup.okhttp3:logging-interceptor:${Version.okhttp_version}"

    // Glide
    const val glide_lib                                      = "com.github.bumptech.glide:glide:${Version.glide_version}"
    const val glide_okhttp_lib                               = "com.github.bumptech.glide:okhttp3-integration:${Version.glide_version}"

    const val glide_transformations_lib                      = "com.github.bumptech.glide:glide:${Version.glide_transformations_version}"

    // Coil
    const val coil_lib                                       = "io.coil-kt:coil:${Version.coil_version}"

    // Room
    const val room_ktx_lib                                   = "androidx.room:room-ktx:${Version.room_version}"
    const val room_runtime_lib                               = "androidx.room:room-runtime:${Version.room_version}"
    const val room_compiler_lib                              = "androidx.room:room-compiler:${Version.room_version}"

    // Lifecycle
    const val lifecycle_extensions_lib                       = "androidx.lifecycle:lifecycle-extensions:${Version.lifecycle_version}"
    const val lifecycle_common_java8_lib                     = "androidx.lifecycle:lifecycle-common-java8:${Version.lifecycle_version}"
    const val lifecycle_compiler_lib                         = "androidx.lifecycle:lifecycle-compiler:${Version.lifecycle_version}"
    const val lifecycle_runtime_ktx_lib                      = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.lifecycle_version}"
    const val viewmodel_ktx_lib                              = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.lifecycle_version}"
    const val livedata_ktx_lib                               = "androidx.lifecycle:lifecycle-livedata-ktx:${Version.lifecycle_version}"

    // Navigation
    const val navigation_fragment_ktx_lib                    = "androidx.navigation:navigation-fragment-ktx:${Version.navigation_version}"
    const val navigation_ui_ktx_lib                          = "androidx.navigation:navigation-ui-ktx:${Version.navigation_version}"

    // Koin
    const val koin_core_lib                                  = "org.koin:koin-core:${Version.koin_version}"
    const val koin_android_scope_lib                         = "org.koin:koin-android-scope:${Version.koin_version}"
    const val koin_android_viewmodel_lib                     = "org.koin:koin-android-viewmodel:${Version.koin_version}"

    // GraphQL
    const val apollo_graphql_lib                             = "com.apollographql.apollo:apollo-runtime:${Version.apollo_graphql_version}"

    // Ktor
    const val ktor_android_lib                               = "io.ktor:ktor-client-android:${Version.ktor_version}"
    const val ktor_json_jvm_lib                              = "io.ktor:ktor-client-json-jvm:${Version.ktor_version}"
    const val ktor_serialization_lib                         = "io.ktor:ktor-client-serialization-jvm:${Version.ktor_version}"
    const val ktor_gson_lib                                  = "io.ktor:ktor-client-gson:${Version.ktor_version}"
    const val ktor_logging_jvm_lib                           = "io.ktor:ktor-client-logging-jvm:${Version.ktor_version}"
    const val ktor_logging                                   = "io.ktor:ktor-client-logging:${Version.ktor_version}"
    const val logback_lib                                    = "ch.qos.logback:logback-classic:${Version.logback_version}"

    // Timber
    const val timber_lib                                     = "com.jakewharton.timber:timber:${Version.timber_version}"

    // Stetho
    const val stetho_lib                                     = "com.facebook.stetho:stetho:${Version.stetho_version}"

    // Recyclerview animators
    const val recyclerview_animators_lib                     = "jp.wasabeef:recyclerview-animators:${Version.recyclerview_animators_version}"

    // Firebase
    const val firebase_auth                                  = "com.google.firebase:firebase-auth:${Version.firebase_auth_version}"
    const val android_gms_play_services                      = "com.google.android.gms:play-services-auth:${Version.android_gms_play_services}"

    // Test
    const val koin_test_lib                                  = "org.koin:koin-test:${Version.koin_test_version}"
    const val junit_lib                                      = "junit:junit:${Version.junit_version}"
    const val test_runner_lib                                = "androidx.test:runner:${Version.test_runner_version}"
    const val espresso_lib                                   = "androidx.test.espresso:espresso-core:${Version.espresso_version}"
}