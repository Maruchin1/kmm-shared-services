package com.maruchin.kmm.architecture.sharedlogic.libs

import io.ktor.client.engine.*
import io.ktor.client.engine.darwin.*

internal actual fun createHttpEngineFactory(): HttpClientEngineFactory<*> = Darwin
