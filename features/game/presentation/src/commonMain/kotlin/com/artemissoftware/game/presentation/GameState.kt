package com.artemissoftware.game.presentation

import com.artemissoftware.game.domain.models.Game

data class GameState(
    val isLoading: Boolean = false,
    val error: String = "",
    val data: List<Game> = emptyList()
)
