package com.artemissoftware.database.di

import app.cash.sqldelight.db.SqlDriver
import com.artemissoftware.database.SqlDriverFactory
import com.artemissoftware.database.TridentGamesDb
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun getDatabaseModule(): Module {
    return module {
        single { SqlDriverFactory().getSqlDriver() }
        single { TridentGamesDb.invoke(get<SqlDriver>()) }
    }
}