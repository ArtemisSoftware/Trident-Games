package com.artemissoftware.game.presentation.di

import com.artemissoftware.game.presentation.details.DetailsViewModel
import com.artemissoftware.game.presentation.game.GameViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val gamePresentationModule = module {
    viewModelOf(::GameViewModel)
    viewModelOf(::DetailsViewModel)
}