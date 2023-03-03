package com.maruchin.kmm.sharedservices.libs

import io.ktor.client.engine.*
import io.ktor.client.engine.darwin.*

internal actual fun createHttpEngineFactory(): HttpClientEngineFactory<*> = Darwin
