package com.artemissoftware.search.presentation

import com.artemissoftware.domain.models.Game

data class SearchState(
    val isLoading: Boolean = false,
    val error: String = "",
    val query: String = "",
    val games: List<Game> = emptyList()
)
