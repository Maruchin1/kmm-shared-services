package com.maruchin.kmm.sharedservices.libs

import io.ktor.client.engine.*

internal expect fun createHttpEngineFactory(): HttpClientEngineFactory<*>
