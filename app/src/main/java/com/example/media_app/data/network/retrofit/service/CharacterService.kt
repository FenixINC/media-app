package com.example.media_app.data.network.retrofit.service

import com.example.media_app.data.network.dto.CharacterResponse
import retrofit2.http.GET

interface CharacterService {

    @GET("/api/characters")
    suspend fun getAllCharacters(): List<CharacterResponse>

    @GET("/api/character/random")
    suspend fun getRandomCharacter(): List<CharacterResponse>
}