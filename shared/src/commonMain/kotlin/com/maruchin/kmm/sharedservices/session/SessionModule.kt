package com.maruchin.kmm.sharedservices.session

import com.maruchin.kmm.sharedservices.session.data.SessionRepository
import com.maruchin.kmm.sharedservices.session.storage.SessionStorage
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

internal val sessionModule = module {
    singleOf(::SessionRepository)
    singleOf(::SessionStorage)
}
