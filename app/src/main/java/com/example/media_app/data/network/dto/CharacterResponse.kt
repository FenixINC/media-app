package com.example.media_app.data.network.dto

import com.google.gson.annotations.SerializedName

data class CharacterResponse(
        @SerializedName("char_id") val id: Int? = 0,
        @SerializedName("name") val name: String? = "",
        @SerializedName("img") val imageUrl: String? = "",
        @SerializedName("status") val status: String? = "",
        @SerializedName("nickname") val nickname: String? = "",
        @SerializedName("birthday") val birthday: String? = "",
        @SerializedName("portrayed") val portrayed: String? = "",
        @SerializedName("category") val category: String? = "",
        @SerializedName("appearance") val appearanceList: List<Int>? = mutableListOf(),
        @SerializedName("occupation") val occupationList: List<String>? = mutableListOf()
)