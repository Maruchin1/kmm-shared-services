package com.maruchin.kmm.sharedservices.core

import io.ktor.client.engine.*
import io.ktor.client.engine.okhttp.*

internal actual fun createHttpEngineFactory(): HttpClientEngineFactory<*> = OkHttp
