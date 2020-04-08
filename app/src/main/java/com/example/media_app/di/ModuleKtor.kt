package com.example.media_app.di

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.features.defaultRequest
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.logging.ANDROID
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.Logging
import io.ktor.http.URLBuilder
import io.ktor.http.takeFrom
import org.koin.dsl.module

private const val BASE_PATH = "https://www.breakingbadapi.com"

private const val GET_ALL_CHARACTERS = "api/characters"

private const val PROVIDE_KTOR_HTTP_CLIENT = "kttor_http_client"

val ktorModule = module {
    single { provideKtor() }
    single { provideCharacterService() }
}

private fun provideKtor() = HttpClient(Android) {
//    install(DefaultRequest) {
//        defaultRequest {
//            url.takeFrom(URLBuilder().takeFrom(basePath).apply {
//                encodedPath += url.encodedPath
//            })
//        }

//        headers.append("Accept","application/xml;q=0.9")
//        headers.append("Authorization", "Bearer 5614ba0e58894bf287985ae0672af8ee")
//    }
    install(Logging) {
        // TODO: Logger.ANDROID is EXPERIMENTAL feature
        logger = Logger.ANDROID
        level = LogLevel.ALL
    }
    install(JsonFeature) {
        serializer = GsonSerializer {
            serializeNulls()
            disableHtmlEscaping()
            create()
        }
    }

    defaultRequest {
        url.takeFrom(URLBuilder().takeFrom(BASE_PATH).apply {
            encodedPath += url.encodedPath
        })
    }
}

private fun provideCharacterService(): String {
    return GET_ALL_CHARACTERS
}