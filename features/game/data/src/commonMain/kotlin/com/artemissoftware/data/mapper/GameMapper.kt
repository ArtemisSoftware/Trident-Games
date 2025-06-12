package com.artemissoftware.data.mapper

import com.artemissoftware.corenetwork.dto.GameDto
import com.artemissoftware.corenetwork.dto.GameListDto
import com.artemissoftware.domain.models.Game

internal fun GameListDto.toGames(): List<Game> {
    return this.games.map { it.toGame() }
}

private fun GameDto.toGame(): Game{
    return Game(
        id = id,
        name = name,
        imageUrl = backgroundImage
    )
}