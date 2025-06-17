package com.artemissoftware.tridentgames

import android.app.Application
import com.artemissoftware.tridentgames.di.initKoin

class TridentGamesApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}