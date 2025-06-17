package com.artemissoftware.tridentgames.di

import com.artemissoftware.corenetwork.di.networkModule
import com.artemissoftware.data.di.gameDataModule
import com.artemissoftware.presentation.di.gamePresentationModule
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

fun initKoin(koinApplication: ((KoinApplication) -> Unit)? = null) {
    startKoin {
        koinApplication?.invoke(this)
        modules(
            networkModule,
            gameDataModule,
            gamePresentationModule,
//            getCoreNetworkModule(),
//            getGameDataModule(),
//            getGameDomainModule(),
//            getGameUiModule(),
//            getSearchDataModule(),
//            getSearchDomainModule(),
//            getSearchUiModule(),
//            getCoreDatabaseModule(),
//            getFavoriteDataModule(),
//            getFavoriteDomainModule(),
//            getFavoriteUiModule()
        )
    }
}