package com.example.media_app.data.repository

import io.ktor.http.HttpMethod
import io.ktor.http.URLProtocol

object Constants {
    const val BASE_URL = "www.breakingbadapi.com"
    const val API_CHARACTERS = "/api/characters"
    const val API_EPISODES = "/api/episodes"

    val PROTOCOL_HTTP = URLProtocol.HTTP
    val PROTOCOL_HTTPS = URLProtocol.HTTPS

    val HTTP_METHOD_GET = HttpMethod.Get
    val HTTP_METHOD_POST = HttpMethod.Post
}