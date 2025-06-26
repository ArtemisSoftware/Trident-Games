package com.artemissoftware.database

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver

actual class SqlDriverFactory actual constructor(context: Any?) {

    private val context = context as Context

    actual fun getSqlDriver(): SqlDriver {
        return AndroidSqliteDriver(
            schema = TridentGamesDb.Schema,
            context = context,
            name = "TridentGames.db",
        )
    }
}