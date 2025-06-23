package com.artemissoftware.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StoreDto(
    @SerialName("id")
    val id: Int,
    @SerialName("store")
    val store: StoreDetailDto,
    @SerialName("url")
    val url: String
)
