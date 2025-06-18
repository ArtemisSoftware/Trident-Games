package com.artemissoftware.network.di

import com.artemissoftware.network.client.KtorClient
import com.artemissoftware.network.source.RawgApiSource
import org.koin.dsl.module

val networkModule = module {
    single { RawgApiSource(httpClient = KtorClient.getInstance()) }
}