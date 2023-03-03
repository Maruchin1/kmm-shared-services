package com.maruchin.kmm.sharedservices.libs

import io.ktor.client.engine.*
import io.ktor.client.engine.okhttp.*

internal actual fun createHttpEngineFactory(): HttpClientEngineFactory<*> = OkHttp
