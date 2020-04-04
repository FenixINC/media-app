package com.example.media_app.data.repository

import com.example.media_app.data.network.dto.CharacterResponse
import com.example.media_app.data.network.retrofit.service.CharacterService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import org.koin.core.inject

class CharacterRepository : BaseRepository {

    private val characterService by inject<CharacterService>()

    private val characterList = mutableListOf<CharacterResponse>()

    fun loadAllCharacters(onSuccess: (List<CharacterResponse>) -> Unit, onError: (e: Exception) -> Unit, onProgress: (Boolean) -> Unit) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val characterResponse = characterService.getAllCharacters()
                onSuccess(characterResponse)
            } catch (e: Exception) {
                onError(e)
            }
        }
    }

    fun loadRandomCharacter(onSuccess: (List<CharacterResponse>) -> Unit, onError: (e: Exception) -> Unit, onProgress: (Boolean) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            val asyncRequest = async {
                characterService.getRandomCharacter()
            }
            try {
                val response = asyncRequest.await()
                characterList.addAll(response)
                onSuccess(characterList)
            } catch (e: Exception) {
                onError(e)
            }
        }
    }
}