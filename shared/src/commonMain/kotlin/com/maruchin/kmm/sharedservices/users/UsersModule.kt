package com.maruchin.kmm.sharedservices.users

import com.maruchin.kmm.sharedservices.session.SessionService
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

internal val usersModule = module {
    singleOf(::SessionService)
    singleOf(::UsersRepository)
    singleOf(::HttpUsersApi) bind UsersApi::class
}
