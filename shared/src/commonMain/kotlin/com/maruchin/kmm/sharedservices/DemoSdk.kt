package com.maruchin.kmm.sharedservices

import com.maruchin.kmm.sharedservices.posts.PostsService
import com.maruchin.kmm.sharedservices.posts.postsModule
import com.maruchin.kmm.sharedservices.session.SessionService
import com.maruchin.kmm.sharedservices.session.sessionModule
import com.maruchin.kmm.sharedservices.users.usersModule
import org.koin.core.KoinApplication
import org.koin.dsl.module

class DemoSdk(config: DemoConfig) {

    private val koinApplication = KoinApplication
        .init()
        .modules(
            coreModule,
            sessionModule,
            usersModule,
            postsModule,
            module { factory { config } }
        )

    val sessionService: SessionService
        get() = getFromKoin()

    val postsService: PostsService
        get() = getFromKoin()

    private inline fun <reified T> getFromKoin(): T = koinApplication.koin.get()
}
