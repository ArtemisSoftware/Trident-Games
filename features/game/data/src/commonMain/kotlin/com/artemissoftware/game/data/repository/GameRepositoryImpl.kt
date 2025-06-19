package com.artemissoftware.game.data.repository

import com.artemissoftware.data.mapper.toGames
import com.artemissoftware.domain.models.Game
import com.artemissoftware.network.source.RawgApiSource
import com.artemissoftware.game.domain.repository.GameRepository

class GameRepositoryImpl(
    private val rawgApiSource: RawgApiSource
) : GameRepository {

    override suspend fun getGames(): Result<List<Game>> {
        val result = rawgApiSource.getGames()

        return if (result.isSuccess) {
            Result.success(result.getOrThrow().toGames())
        } else {
            Result.failure(result.exceptionOrNull()!!)
        }
    }
}