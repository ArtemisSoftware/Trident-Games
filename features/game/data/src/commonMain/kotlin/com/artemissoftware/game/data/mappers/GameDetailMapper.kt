package com.artemissoftware.game.data.mappers

import com.artemissoftware.game.domain.models.Developer
import com.artemissoftware.game.domain.models.GameDetails
import com.artemissoftware.game.domain.models.Platform
import com.artemissoftware.game.domain.models.Store
import com.artemissoftware.game.domain.models.Tag

fun GameDetails.toGameDetails(): GameDetails {
    return GameDetails(
        name = name,
        id = id,
        description = description,
        backgroundImage = backgroundImage,
        additionalImage = additionalImage,
        platforms = platforms.map {
            Platform(
                name = it.name,
                image = it.image
            )
        },
        stores = stores.map {
            Store(
                name = it.name,
                image = it.image,
                gameCount = it.gameCount,
                domain = it.domain
            )
        },
        developers = developers.map {
            Developer(
                name = it.name,
                image = it.image,
                gameCount = it.gameCount
            )
        },
        tags = tags.map {
            Tag(
                name = it.name,
                image = it.image
            )
        }
    )
}