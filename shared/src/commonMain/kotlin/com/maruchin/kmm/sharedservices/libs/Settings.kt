package com.maruchin.kmm.sharedservices.libs

import com.maruchin.kmm.sharedservices.SharedConfig
import com.russhwolf.settings.Settings

internal expect fun createSettings(config: SharedConfig): Settings
