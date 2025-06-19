package com.artemissoftware.data.mapper

import com.artemissoftware.domain.models.Game
import com.artemissoftware.network.dto.GameDto
import com.artemissoftware.network.dto.GameListDto

fun GameListDto.toGames(): List<Game> {
    return this.games.map { it.toGame() }
}

private fun GameDto.toGame(): Game {
    return Game(
        id = id,
        name = name,
        imageUrl = backgroundImage
    )
}