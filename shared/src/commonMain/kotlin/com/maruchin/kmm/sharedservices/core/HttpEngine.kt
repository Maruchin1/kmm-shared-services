package com.maruchin.kmm.sharedservices.core

import io.ktor.client.engine.*

internal expect fun createHttpEngineFactory(): HttpClientEngineFactory<*>
