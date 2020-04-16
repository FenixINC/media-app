// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        jcenter()

    }
    dependencies {
        classpath("com.android.tools.build:gradle:${Version.gradle_plugin_version}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlin_plugin_version}")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
        classpath("com.github.ben-manes:gradle-versions-plugin:${Version.github_ben_means_plugin_version}")
        classpath("com.apollographql.apollo:apollo-gradle-plugin:${Version.apollo_graphql_plugin_version}")
        classpath("com.google.gms:google-services:${Version.google_services_version}")

//        classpath(kotlin("gradle-plugin", version = "${Version.kotlin_version})"))
//        classpath(kotlin("serialization", version = "${Version.kotlin_version})"))
//        classpath("org.jetbrains.kotlin:kotlin-serialization:${Version.kotlin_version}")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks.register("clean").configure {
    delete(rootProject.buildDir)
}