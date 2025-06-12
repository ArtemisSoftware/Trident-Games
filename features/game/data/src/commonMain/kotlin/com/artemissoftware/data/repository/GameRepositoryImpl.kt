package com.artemissoftware.data.repository

import com.artemissoftware.corenetwork.source.RawgApiSource
import com.artemissoftware.data.mapper.toGames
import com.artemissoftware.domain.models.Game
import com.artemissoftware.domain.repository.GameRepository

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