package com.artemissoftware.corenetwork.di

import com.artemissoftware.corenetwork.client.KtorClient
import com.artemissoftware.corenetwork.source.RawgApiSource
import org.koin.dsl.module

val networkModule = module {
    single { RawgApiSource(httpClient = KtorClient.getInstance()) }
}