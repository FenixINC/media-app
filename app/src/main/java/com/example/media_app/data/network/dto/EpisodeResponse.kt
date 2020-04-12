package com.example.media_app.data.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EpisodeResponse(
    @SerialName(value = "episode_id") val episodeId: Int? = 0,
    @SerialName(value = "title") val title: String? = "",
    @SerialName(value = "season") val season: Int? = 0,
    @SerialName(value = "episode") val episode: Int? = 0,
    @SerialName(value = "air_date") val airDate: String? = "",
    @SerialName(value = "characters") val characters: List<String>? = mutableListOf()
)