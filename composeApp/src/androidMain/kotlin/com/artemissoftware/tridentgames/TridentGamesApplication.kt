package com.artemissoftware.tridentgames

import android.app.Application
import com.artemissoftware.tridentgames.di.initKoin
import org.koin.dsl.module

class TridentGamesApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        initKoin{
            it.modules(
                module {
                    single { this@TridentGamesApplication.applicationContext }
                }
            )
        }
    }
}