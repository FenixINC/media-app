package com.example.media_app.data.repository

import com.example.media_app.data.database.dao.CharacterDao
import com.example.media_app.data.mapper.mapToCharacterEntityList
import com.example.media_app.data.network.dto.CharacterResponse
import com.example.media_app.data.network.retrofit.service.CharacterService
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.readText
import io.ktor.http.HttpMethod
import io.ktor.http.URLProtocol
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.serialization.ImplicitReflectionSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import kotlinx.serialization.parseList
import org.koin.core.inject

class CharacterRepository : BaseRepository {

    private val characterService by inject<CharacterService>()
    private val characterDao by inject<CharacterDao>()

    private val ktor by inject<HttpClient>()
    private val ktorCharacterService by inject<String>()

    private val characterList = mutableListOf<CharacterResponse>()

    fun loadAllCharacters(
            onSuccess: (List<CharacterResponse>) -> Unit,
            onError: (e: Exception) -> Unit,
            onProgress: (Boolean) -> Unit
    ) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val characterResponse = characterService.getAllCharacters()
                characterDao.insert(characterResponse.mapToCharacterEntityList())
                onSuccess(characterResponse)
            } catch (e: Exception) {
                onError(e)
            }
        }
    }

    fun ktorLoadAllCharacters(
            onSuccess: (List<CharacterResponse>) -> Unit,
            onError: (e: Exception) -> Unit,
            onProgress: (Boolean) -> Unit
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                var response = mutableListOf<CharacterResponse>()
                //TODO: fix io.ktor.client.engine.ClientEngineClosedException: Client already closed
                ktor.use { client ->
//                    response = client.get<List<CharacterResponse>>("https://www.breakingbadapi.com/api/characters").toMutableList()
                    response = client.get { url { path(ktorCharacterService) } }
                }
                onSuccess(response)
            } catch (e: Exception) {
                onError(e)
            }
        }
    }

    @ImplicitReflectionSerializer
    suspend fun loadCharacterList(): List<CharacterResponse> {
        val response = ktor.get<HttpResponse> {
            url {
                protocol = URLProtocol.HTTPS
                method = HttpMethod.Get
                host = "www.breakingbadapi.com"
                encodedPath = "/api/characters"
            }
        }

        val jsonBody = response.readText()
//        Json {
//            parseResponse(jsonBody)
//        }
        return Json(JsonConfiguration.Stable.copy(
                ignoreUnknownKeys = true,
                isLenient = true,
                useArrayPolymorphism = true
        )).parseList(jsonBody)
//        return Json.nonstrict.parseList(jsonBody)
    }
}