package com.maruchin.kmm.sharedservices.libs

import com.maruchin.kmm.sharedservices.SharedConfig
import com.russhwolf.settings.KeychainSettings
import com.russhwolf.settings.Settings

internal actual fun createSettings(config: SharedConfig): Settings {
    return KeychainSettings(config.settingsName)
}