package com.maruchin.kmm.sharedservices.core

import io.ktor.client.engine.*
import io.ktor.client.engine.darwin.*

internal actual fun createHttpEngineFactory(): HttpClientEngineFactory<*> = Darwin
