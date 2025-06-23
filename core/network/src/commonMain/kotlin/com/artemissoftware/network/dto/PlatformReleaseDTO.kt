package com.artemissoftware.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlatformReleaseDTO(
    @SerialName("platform")
    val platform: PlatformGameCountDto,
    @SerialName("released_at")
    val releasedAt: String?,
)
