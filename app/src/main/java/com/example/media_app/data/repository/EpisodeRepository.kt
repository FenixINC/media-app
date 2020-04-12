package com.example.media_app.data.repository

import com.example.media_app.data.network.dto.EpisodeResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.readText
import io.ktor.http.HttpMethod
import io.ktor.http.URLProtocol
import kotlinx.serialization.ImplicitReflectionSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import kotlinx.serialization.parseList
import org.koin.core.inject

class EpisodeRepository : BaseRepository {

    private val ktor by inject<HttpClient>()

    @ImplicitReflectionSerializer
    suspend fun loadEpisodesList(): List<EpisodeResponse> {
        val response = ktor.get<HttpResponse> {
            url {
                protocol = URLProtocol.HTTPS
                method = HttpMethod.Get
                host = "www.breakingbadapi.com"
                encodedPath = "/api/episodes"
            }
        }

        val jsonBody = response.readText()
        return Json(JsonConfiguration.Stable.copy(
                ignoreUnknownKeys = true,
                isLenient = true,
                useArrayPolymorphism = true
        )).parseList(jsonBody)
    }

}