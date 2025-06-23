package com.artemissoftware.game.data.mappers

import com.artemissoftware.game.domain.models.Developer
import com.artemissoftware.game.domain.models.GameDetails
import com.artemissoftware.game.domain.models.Platform
import com.artemissoftware.game.domain.models.Store
import com.artemissoftware.game.domain.models.Tag
import com.artemissoftware.network.dto.GameDetailDto

fun GameDetailDto.toGameDetails(): GameDetails {
    return GameDetails(
        name = name,
        id = id,
        description = descriptionRaw,
        backgroundImage = backgroundImage,
        additionalImage = backgroundImageAdditional,
        platforms = platforms.map {
            Platform(
                name = it.platform.name,
                image = it.platform.imageBackground
            )
        },
        stores = stores.map {
            Store(
                name = it.store.name,
                image = it.store.imageBackground,
                gameCount = it.store.gamesCount,
                domain = it.store.domain
            )
        },
        developers = developers.map {
            Developer(
                name = it.name,
                image = it.imageBackground,
                gameCount = it.gamesCount
            )
        },
        tags = tags.map {
            Tag(
                name = it.name,
                image = it.imageBackground
            )
        }
    )
}