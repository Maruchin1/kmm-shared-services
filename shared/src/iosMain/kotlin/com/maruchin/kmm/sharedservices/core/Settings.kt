package com.maruchin.kmm.sharedservices.core

import com.maruchin.kmm.sharedservices.core.DemoConfig
import com.russhwolf.settings.KeychainSettings
import com.russhwolf.settings.Settings

internal actual fun createSettings(config: DemoConfig): Settings {
    return KeychainSettings(config.settingsName)
}
