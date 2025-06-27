package com.artemissoftware.favorite.repository

import com.artemissoftware.domain.models.Game
import kotlinx.coroutines.flow.Flow

interface FavoriteRepository {
    fun getAllGames(): Flow<List<Game>>
    suspend fun upsert(id: Int, image: String, name: String)
    suspend fun delete(id: Int)
}