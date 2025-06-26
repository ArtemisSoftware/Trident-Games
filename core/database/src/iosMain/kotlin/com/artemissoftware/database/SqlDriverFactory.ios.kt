package com.artemissoftware.database

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver

actual class SqlDriverFactory actual constructor(context: Any?) {
    actual fun getSqlDriver(): SqlDriver {
        return NativeSqliteDriver(
            TridentGamesDb.Schema,
            name = "TridentGames.db"
        )
    }
}