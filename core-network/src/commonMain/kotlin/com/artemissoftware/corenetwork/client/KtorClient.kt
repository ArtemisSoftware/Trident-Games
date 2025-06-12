package com.artemissoftware.corenetwork.client

import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.accept
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object KtorClient {

    fun getInstance(): HttpClient = HttpClient {

        install(ContentNegotiation) {
            json(
                json = Json {
                    ignoreUnknownKeys = true
                }
            )
        }

        install(HttpTimeout) {
            socketTimeoutMillis = 3_000L
            connectTimeoutMillis = 3_000L
            requestTimeoutMillis = 3_000L
        }

        install(DefaultRequest) {
            url {
                host = "api.rawg.io"
                protocol = URLProtocol.HTTPS
                contentType(ContentType.Application.Json)
                accept(ContentType.Application.Json)
            }
        }



    }
}