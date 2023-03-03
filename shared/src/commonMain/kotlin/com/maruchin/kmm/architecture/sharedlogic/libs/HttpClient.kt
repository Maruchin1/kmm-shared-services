package com.maruchin.kmm.architecture.sharedlogic.libs

import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

internal fun createHttpClient(): HttpClient {
    return HttpClient(createHttpEngineFactory()) {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
    }
}

internal expect fun createHttpEngineFactory(): HttpClientEngineFactory<*>
