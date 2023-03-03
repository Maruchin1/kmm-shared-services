package com.maruchin.kmm.architecture.sharedlogic.users

import com.maruchin.kmm.architecture.sharedlogic.users.api.UsersApi
import com.maruchin.kmm.architecture.sharedlogic.users.data.UsersRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

internal val usersModule = module {
    singleOf(::UsersService)
    singleOf(::UsersRepository)
    singleOf(::UsersApi)
}
