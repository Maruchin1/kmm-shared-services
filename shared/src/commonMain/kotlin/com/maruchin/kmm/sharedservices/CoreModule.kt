package com.maruchin.kmm.sharedservices

import com.russhwolf.settings.Settings
import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.koin.dsl.module

internal val coreModule = module {
    single {
        HttpClient(createHttpEngineFactory()) {
            install(ContentNegotiation) {
                json(Json { ignoreUnknownKeys = true })
            }
        }
    }
    factory { createSettings(get()) }
}

internal expect fun createHttpEngineFactory(): HttpClientEngineFactory<*>

internal expect fun createSettings(config: DemoConfig): Settings
