package com.artemissoftware.game.data.di

import com.artemissoftware.game.data.repository.GameRepositoryImpl
import com.artemissoftware.game.domain.repository.GameRepository
import org.koin.dsl.module

val gameDataModule = module {
    factory<GameRepository> { GameRepositoryImpl(rawgApiSource = get(), favoriteDao = get()) }
}