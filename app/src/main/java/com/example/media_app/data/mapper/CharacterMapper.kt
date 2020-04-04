package com.example.media_app.data.mapper

import com.example.media_app.data.database.entity.CharacterEntity
import com.example.media_app.data.network.dto.CharacterResponse

fun List<CharacterResponse>.mapToCharacterEntityList(): List<CharacterEntity> {
    val characterEntityList = mutableListOf<CharacterEntity>()
    iterator().forEach {
        characterEntityList.add(it.mapToCharacterEntity())
    }
    return characterEntityList
}

fun CharacterResponse.mapToCharacterEntity() = CharacterEntity(
        id = id,
        name = name,
        imageUrl = imageUrl,
        status = status,
        nickname = nickname,
        birthday = birthday,
        portrayed = portrayed,
        category = category
)