package com.artemissoftware.game.data.repository

import com.artemissoftware.data.mapper.toGames
import com.artemissoftware.database.FavoriteDao
import com.artemissoftware.domain.models.Game
import com.artemissoftware.game.data.mappers.toGameDetails
import com.artemissoftware.game.domain.models.GameDetails
import com.artemissoftware.network.source.RawgApiSource
import com.artemissoftware.game.domain.repository.GameRepository

class GameRepositoryImpl(
    private val rawgApiSource: RawgApiSource,
    private val favoriteDao: FavoriteDao
) : GameRepository {

    override suspend fun getGames(): Result<List<Game>> {
        val result = rawgApiSource.getGames()

        return if (result.isSuccess) {
            Result.success(result.getOrThrow().toGames())
        } else {
            Result.failure(result.exceptionOrNull()!!)
        }
    }

    override suspend fun getDetails(id: Int): Result<GameDetails> {
        val result = rawgApiSource.getDetails(id)

        return if (result.isSuccess) {
            Result.success(result.getOrThrow().toGameDetails())
        } else {
            Result.failure(result.exceptionOrNull()!!)
        }
    }

    override suspend fun save(id: Int, image: String, name: String) {
        favoriteDao.upsert(id, image, name)
    }

    override suspend fun delete(id: Int) {
        favoriteDao.delete(id)
    }
}