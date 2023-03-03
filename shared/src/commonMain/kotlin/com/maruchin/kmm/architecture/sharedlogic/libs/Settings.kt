package com.maruchin.kmm.architecture.sharedlogic.libs

import com.maruchin.kmm.architecture.sharedlogic.SharedConfig
import com.russhwolf.settings.Settings

internal expect fun createSettings(config: SharedConfig): Settings
