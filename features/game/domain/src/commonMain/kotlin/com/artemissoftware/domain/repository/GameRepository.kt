package com.artemissoftware.domain.repository

import com.artemissoftware.domain.models.Game

interface GameRepository {
    suspend fun getGames(): Result<List<Game>>
}