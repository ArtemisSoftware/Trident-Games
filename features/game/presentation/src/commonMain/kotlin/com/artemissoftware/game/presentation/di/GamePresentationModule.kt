package com.artemissoftware.game.presentation.di

import com.artemissoftware.game.presentation.GameViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val gamePresentationModule = module {
    viewModelOf(::GameViewModel)
}