package com.maruchin.kmm.sharedservices

import com.maruchin.kmm.sharedservices.libs.libsModule
import com.maruchin.kmm.sharedservices.posts.PostsService
import com.maruchin.kmm.sharedservices.posts.postsModule
import com.maruchin.kmm.sharedservices.session.sessionModule
import com.maruchin.kmm.sharedservices.users.UsersService
import com.maruchin.kmm.sharedservices.users.usersModule
import org.koin.core.KoinApplication
import org.koin.dsl.module

class SharedLibrary(config: SharedConfig) {

    internal val koinApplication: KoinApplication

    init {
        val configModule = module { factory { config } }
        koinApplication = KoinApplication.init().apply {
            modules(configModule, libsModule, sessionModule, usersModule, postsModule)
        }
    }

    val usersService: UsersService
        get() = getFromKoin()

    val postsService: PostsService
        get() = getFromKoin()

    private inline fun <reified T> getFromKoin(): T = koinApplication.koin.get()
}
