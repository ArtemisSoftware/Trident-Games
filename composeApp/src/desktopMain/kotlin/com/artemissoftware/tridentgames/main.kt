package com.artemissoftware.tridentgames

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.artemissoftware.tridentgames.di.initKoin

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "TridentGames",
    ) {
        initKoin()
        App()
    }
}