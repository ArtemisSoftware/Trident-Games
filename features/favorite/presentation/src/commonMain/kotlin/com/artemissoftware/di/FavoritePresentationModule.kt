package com.artemissoftware.di

import com.artemissoftware.favorite.FavoriteViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val favoritePresentationModule = module {
    viewModelOf(::FavoriteViewModel)
}