package com.artemissoftware.favorite.di

import com.artemissoftware.favorite.repository.FavoriteRepository
import com.artemissoftware.favorite.repository.FavoriteRepositoryImpl
import org.koin.dsl.module

val favoriteDataModule = module {
    factory<FavoriteRepository> { FavoriteRepositoryImpl(favoriteDao = get()) }
}