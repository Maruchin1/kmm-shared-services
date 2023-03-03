package com.maruchin.kmm.architecture.sharedlogic.libs

import com.maruchin.kmm.architecture.sharedlogic.SharedConfig
import com.russhwolf.settings.KeychainSettings
import com.russhwolf.settings.Settings

internal actual fun createSettings(config: SharedConfig): Settings {
    return KeychainSettings(config.settingsName)
}
