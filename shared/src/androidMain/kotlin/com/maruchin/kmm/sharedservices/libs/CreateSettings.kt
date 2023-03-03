package com.maruchin.kmm.sharedservices.libs

import android.content.Context
import com.maruchin.kmm.sharedservices.SharedConfig
import com.russhwolf.settings.Settings
import com.russhwolf.settings.SharedPreferencesSettings

internal actual fun createSettings(config: SharedConfig): Settings {
    return SharedPreferencesSettings(
        delegate = config.context.getSharedPreferences(config.settingsName, Context.MODE_PRIVATE),
        commit = true
    )
}
