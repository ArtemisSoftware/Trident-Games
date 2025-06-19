package com.artemissoftware.search.data.repository

import com.artemissoftware.data.mapper.toGames
import com.artemissoftware.domain.models.Game
import com.artemissoftware.network.source.RawgApiSource
import com.artemissoftware.search.domain.repository.SearchRepository

class SearchRepositoryImpl(
    private val rawgApiSource: RawgApiSource
) : SearchRepository {

    override suspend fun search(query: String): Result<List<Game>> {
        val result = rawgApiSource.search(query = query)

        return if (result.isSuccess) {
            Result.success(result.getOrThrow().toGames())
        } else {
            Result.failure(result.exceptionOrNull()!!)
        }
//        return try {
//            val response = rawgApiSource.search(q)
//            val data = response.getOrThrow().results.toDomainListOfGames()
//            Result.success(data)
//        } catch (e: Exception) {
//            Result.failure(e)
//        }
    }
}