package com.maruchin.kmm.architecture.sharedlogic.libs

import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

internal val libsModule = module {
    single { createHttpClient() }
    single { createSettings(get()) }
    factory { Dispatchers.Unconfined }
}
