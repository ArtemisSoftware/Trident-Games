package com.artemissoftware.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DeveloperDto(
    @SerialName("games_count")
    val gamesCount: Int,
    @SerialName("id")
    val id: Int,
    @SerialName("image_background")
    val imageBackground: String,
    @SerialName("name")
    val name: String,
    @SerialName("slug")
    val slug: String
)
