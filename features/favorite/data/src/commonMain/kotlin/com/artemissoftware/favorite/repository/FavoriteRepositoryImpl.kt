package com.artemissoftware.favorite.repository

import com.artemissoftware.database.FavoriteDao
import com.artemissoftware.domain.models.Game
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class FavoriteRepositoryImpl(
    private val favoriteDao: FavoriteDao
) : FavoriteRepository {

    override fun getAllGames(): Flow<List<Game>> {
        return favoriteDao
            .getAllGames()
            .map { list ->
                list.map {
                    Game(
                        id = it.id.toInt(),
                        name = it.name,
                        imageUrl = it.image
                    )
                }
            }
    }

    override suspend fun upsert(id: Int, image: String, name: String) {
        favoriteDao.upsert(id, image, name)
    }

    override suspend fun delete(id: Int) {
        favoriteDao.delete(id)
    }
}