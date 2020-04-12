package com.example.media_app.data.repository

import com.example.media_app.data.network.dto.EpisodeResponse
import com.example.media_app.data.repository.Constants.API_EPISODES
import com.example.media_app.data.repository.Constants.BASE_URL
import com.example.media_app.data.repository.Constants.HTTP_METHOD_GET
import com.example.media_app.data.repository.Constants.PROTOCOL_HTTP
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.readText
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
                protocol = PROTOCOL_HTTP
                method = HTTP_METHOD_GET
                host = BASE_URL
                encodedPath = API_EPISODES
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