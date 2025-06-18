package com.artemissoftware.game.data.mapper

import com.artemissoftware.network.dto.GameDto
import com.artemissoftware.network.dto.GameListDto
import com.artemissoftware.game.domain.models.Game

internal fun GameListDto.toGames(): List<Game> {
    return this.games.map { it.toGame() }
}

private fun GameDto.toGame(): Game {
    return Game(
        id = id,
        name = name,
        imageUrl = backgroundImage
    )
}