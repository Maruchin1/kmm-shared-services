package com.maruchin.kmm.sharedservices

import com.russhwolf.settings.ExperimentalSettingsImplementation
import com.russhwolf.settings.KeychainSettings
import com.russhwolf.settings.Settings
import io.ktor.client.engine.*
import io.ktor.client.engine.darwin.*

internal actual fun createHttpEngineFactory(): HttpClientEngineFactory<*> = Darwin

@OptIn(ExperimentalSettingsImplementation::class)
internal actual fun createSettings(config: DemoConfig): Settings {
    return KeychainSettings(config.settingsName)
}
