package com.artemissoftware.game.presentation.game

import com.artemissoftware.domain.models.Game

data class GameState(
    val isLoading: Boolean = false,
    val error: String = "",
    val data: List<Game> = emptyList()
)
