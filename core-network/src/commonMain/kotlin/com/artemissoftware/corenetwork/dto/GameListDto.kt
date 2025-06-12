package com.artemissoftware.corenetwork.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GameListDto(
    @SerialName("results")
    val games: List<GameDto>,
)