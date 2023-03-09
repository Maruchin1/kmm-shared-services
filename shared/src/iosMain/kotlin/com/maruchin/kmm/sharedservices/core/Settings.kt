package com.maruchin.kmm.sharedservices.core

import com.russhwolf.settings.ExperimentalSettingsImplementation
import com.russhwolf.settings.KeychainSettings
import com.russhwolf.settings.Settings

@OptIn(ExperimentalSettingsImplementation::class)
internal actual fun createSettings(config: DemoConfig): Settings {
    return KeychainSettings(config.settingsName)
}
