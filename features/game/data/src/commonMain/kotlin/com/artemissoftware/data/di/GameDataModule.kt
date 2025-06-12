package com.artemissoftware.data.di

import com.artemissoftware.data.repository.GameRepositoryImpl
import com.artemissoftware.domain.repository.GameRepository
import org.koin.dsl.module

val gameDataModule = module {
    factory<GameRepository> { GameRepositoryImpl(rawgApiSource = get()) }
}