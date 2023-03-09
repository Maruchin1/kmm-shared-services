package com.maruchin.kmm.sharedservices.core

import com.maruchin.kmm.sharedservices.core.DemoConfig
import com.russhwolf.settings.Settings

internal expect fun createSettings(config: DemoConfig): Settings
