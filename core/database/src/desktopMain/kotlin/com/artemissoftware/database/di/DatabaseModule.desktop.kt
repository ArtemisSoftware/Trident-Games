package com.artemissoftware.database.di

import com.artemissoftware.database.SqlDriverFactory
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun getDatabaseModule(): Module {
    return module {
        single { SqlDriverFactory().getSqlDriver() }
//        single {
//            val driver = get<SqlDriver>()
//            AppDatabase.invoke(driver)
//        }

    }
}