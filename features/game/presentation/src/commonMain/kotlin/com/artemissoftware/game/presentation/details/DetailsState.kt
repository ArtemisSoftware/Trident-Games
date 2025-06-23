package com.artemissoftware.game.presentation.details

import com.artemissoftware.game.domain.models.GameDetails

data class DetailsState(
    val isLoading: Boolean = false,
    val error: String = "",
    val data: GameDetails? = null
)
