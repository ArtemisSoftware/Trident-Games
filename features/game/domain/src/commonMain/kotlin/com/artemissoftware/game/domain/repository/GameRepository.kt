package com.artemissoftware.game.domain.repository

import com.artemissoftware.domain.models.Game
import com.artemissoftware.game.domain.models.GameDetails

interface GameRepository {
    suspend fun getGames(): Result<List<Game>>
    suspend fun getDetails(id: Int): Result<GameDetails>
    suspend fun save(id: Int, image: String, name: String)
    suspend fun delete(id: Int)
}