package com.artemissoftware.game.domain.repository

import com.artemissoftware.domain.models.Game

interface GameRepository {
    suspend fun getGames(): Result<List<Game>>
}