package com.maruchin.kmm.sharedservices.session

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

internal val sessionModule = module {
    singleOf(::SessionRepository)
    singleOf(::SessionStorage)
}
