package com.artemissoftware.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ParentPlatformDto(
    @SerialName("platform")
    val platform: PlatformDto
)
