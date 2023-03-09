package com.maruchin.kmm.sharedservices

import com.maruchin.kmm.sharedservices.core.DemoConfig
import com.maruchin.kmm.sharedservices.core.coreDependenciesModule
import com.maruchin.kmm.sharedservices.core.coreModule
import com.maruchin.kmm.sharedservices.posts.PostsService
import com.maruchin.kmm.sharedservices.posts.postsModule
import com.maruchin.kmm.sharedservices.session.sessionModule
import com.maruchin.kmm.sharedservices.users.UsersService
import com.maruchin.kmm.sharedservices.users.usersModule
import org.koin.core.KoinApplication

class DemoSdk(config: DemoConfig) {

    private val koinApplication = KoinApplication
        .init()
        .modules(
            coreModule,
            coreDependenciesModule(config),
            sessionModule,
            usersModule,
            postsModule,
        )

    val usersService: UsersService
        get() = getFromKoin()

    val postsService: PostsService
        get() = getFromKoin()

    private inline fun <reified T> getFromKoin(): T = koinApplication.koin.get()
}
