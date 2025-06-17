package com.artemissoftware.presentation.di

import com.artemissoftware.presentation.GameViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val gamePresentationModule = module {
    viewModelOf(::GameViewModel)
}