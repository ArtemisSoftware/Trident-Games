package com.artemissoftware.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AddedByStatusDto(
    @SerialName("beaten")
    val beaten: Int,
    @SerialName("dropped")
    val dropped: Int,
    @SerialName("owned")
    val owned: Int,
    @SerialName("playing")
    val playing: Int,
    @SerialName("toplay")
    val toplay: Int,
    @SerialName("yet")
    val yet: Int
)
