package com.artemissoftware.tridentgames

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform