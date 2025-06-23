package com.artemissoftware.network.source

import com.artemissoftware.network.dto.GameDetailDto
import com.artemissoftware.network.dto.GameListDto
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

    suspend fun search(query: String): Result<GameListDto> {
        return try {
            val response = httpClient.get("api/games") {
                url {
                    parameter("key", "1abb1867f52548a4aa9f54dd4946af2f")
                    parameter("search", query)
                }
            }.body<GameListDto>()
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getDetails(id: Int): Result<GameDetailDto> {
        return try {
            val response = httpClient.get("api/games/${id}") {
                url {
                    parameter("key", "1abb1867f52548a4aa9f54dd4946af2f")
                }
            }.body<GameDetailDto>()
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }

    }
}