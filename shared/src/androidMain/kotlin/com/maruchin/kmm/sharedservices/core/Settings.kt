package com.maruchin.kmm.sharedservices.core

import android.content.Context
import com.russhwolf.settings.Settings
import com.russhwolf.settings.SharedPreferencesSettings
import org.koin.dsl.module

internal actual fun createSettings(config: DemoConfig): Settings {
    return SharedPreferencesSettings(
        delegate = config.context.getSharedPreferences(config.settingsName, Context.MODE_PRIVATE),
        commit = true
    )
}
