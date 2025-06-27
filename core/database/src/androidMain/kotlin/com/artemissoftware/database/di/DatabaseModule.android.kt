package com.artemissoftware.database.di

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import com.artemissoftware.database.FavoriteDao
import com.artemissoftware.database.SqlDriverFactory
import com.artemissoftware.database.TridentGamesDb
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun getDatabaseModule(): Module {
    return module {
        single<SqlDriver> { SqlDriverFactory(get<Context>()).getSqlDriver() }
        single<TridentGamesDb> { TridentGamesDb.invoke(get<SqlDriver>()) }
        single<FavoriteDao> { FavoriteDao(database = get()) }
    }
}