package com.maruchin.kmm.sharedservices.core

import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.serialization.json.Json
import org.koin.dsl.module

internal val coreModule = module {
    single {
        HttpClient(get<HttpClientEngineFactory<*>>()) {
            install(ContentNegotiation) {
                json(Json { ignoreUnknownKeys = true })
            }
        }
    }
}

internal fun coreDependenciesModule(config: DemoConfig) = module {

    factory { config }

    factory { createHttpEngineFactory() }

    single { createSettings(get()) }

    factory { Dispatchers.Default }

    single { CoroutineScope(SupervisorJob() + Dispatchers.Default) }
}
