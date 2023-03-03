package com.maruchin.kmm.architecture.sharedlogic.session

import com.maruchin.kmm.architecture.sharedlogic.session.data.SessionRepository
import com.maruchin.kmm.architecture.sharedlogic.session.storage.SessionStorage
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

internal val sessionModule = module {
    singleOf(::SessionRepository)
    singleOf(::SessionStorage)
}
