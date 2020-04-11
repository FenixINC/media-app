package com.example.media_app.data.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterResponse(
        @SerialName(value = "char_id") val id: Int? = 0,
        @SerialName(value = "name") val name: String? = "",
        @SerialName(value = "img") val imageUrl: String? = "",
        @SerialName(value = "status") val status: String? = "",
        @SerialName(value = "nickname") val nickname: String? = "",
        @SerialName(value = "birthday") val birthday: String? = "",
        @SerialName(value = "portrayed") val portrayed: String? = "",
        @SerialName(value = "category") val category: String? = "",
        @SerialName(value = "appearance") val appearanceList: List<Int>? = mutableListOf(),
        @SerialName(value = "occupation") val occupationList: List<String>? = mutableListOf()
)