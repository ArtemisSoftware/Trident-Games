package com.artemissoftware.tridentgames.di

import com.artemissoftware.network.di.networkModule
import com.artemissoftware.game.data.di.gameDataModule
import com.artemissoftware.game.presentation.di.gamePresentationModule
import com.artemissoftware.search.data.di.searchDataModule
import com.artemissoftware.search.presentation.di.searchPresentationModule
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

fun initKoin(koinApplication: ((KoinApplication) -> Unit)? = null) {
    startKoin {
        koinApplication?.invoke(this)
        modules(
            networkModule,
            gameDataModule,
            gamePresentationModule,
            searchDataModule,
            searchPresentationModule

//            getCoreDatabaseModule(),
//            getFavoriteDataModule(),
//            getFavoriteDomainModule(),
//            getFavoriteUiModule()
        )
    }
}