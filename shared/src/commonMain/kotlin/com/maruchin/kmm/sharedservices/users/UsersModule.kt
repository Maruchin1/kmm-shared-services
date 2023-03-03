package com.maruchin.kmm.sharedservices.users

import com.maruchin.kmm.sharedservices.users.api.UsersApi
import com.maruchin.kmm.sharedservices.users.data.UsersRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

internal val usersModule = module {
    singleOf(::UsersService)
    singleOf(::UsersRepository)
    singleOf(::UsersApi)
}
