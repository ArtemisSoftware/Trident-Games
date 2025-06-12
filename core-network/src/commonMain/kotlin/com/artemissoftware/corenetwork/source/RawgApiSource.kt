package com.artemissoftware.corenetwork.source

import com.artemissoftware.corenetwork.dto.GameListDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class RawgApiSource(
    private val httpClient: HttpClient
) {

    suspend fun getGames(): Result<GameListDto> {
        return try {
            val response = httpClient
                .get("api/games") {
                    url {
                        parameter("key", "1abb1867f52548a4aa9f54dd4946af2f")
                    }
                }
                    .body<GameListDto>()

            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}