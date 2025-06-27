package com.artemissoftware.database

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow

class FavoriteDao(
    private val database: TridentGamesDb
){
   private val query = database.tridentGamesDbQueries


    fun getAllGames(): Flow<List<Game>> {
        return query.getAllGames()
            .asFlow()
            .mapToList(Dispatchers.IO)
    }

    fun upsert(id: Int, image: String, name: String) {
        query.upsert(id.toLong(), image, name)
    }

    fun delete(id: Int) {
        query.delete(id.toLong())
    }
}