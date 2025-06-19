package com.artemissoftware.search.presentation.di

import com.artemissoftware.search.presentation.SearchViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val searchPresentationModule = = module {
    viewModel { SearchViewModel(searchRepository = get()) }
}