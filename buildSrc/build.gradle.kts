import org.gradle.kotlin.dsl.`kotlin-dsl`

plugins {
    `kotlin-dsl`
}
repositories {
    google()
    jcenter()
    maven { url = uri("https://jitpack.io") }
}
