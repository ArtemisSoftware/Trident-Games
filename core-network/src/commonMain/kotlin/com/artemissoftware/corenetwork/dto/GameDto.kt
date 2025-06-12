package com.artemissoftware.corenetwork.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GameDto(
    @SerialName("background_image")
    val backgroundImage: String,
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
)