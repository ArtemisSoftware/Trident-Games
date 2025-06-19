package com.artemissoftware.search.domain.repository

import com.artemissoftware.domain.models.Game

interface SearchRepository {

    suspend fun search(query: String): Result<List<Game>>

}