package com.artemissoftware.search.data.di

import com.artemissoftware.search.data.repository.SearchRepositoryImpl
import com.artemissoftware.search.domain.repository.SearchRepository
import org.koin.dsl.module

val searchDataModule = module {
    factory<SearchRepository> { SearchRepositoryImpl(rawgApiSource = get()) }
}