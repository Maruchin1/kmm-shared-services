package com.maruchin.kmm.architecture.sharedlogic

import com.maruchin.kmm.architecture.sharedlogic.libs.libsModule
import com.maruchin.kmm.architecture.sharedlogic.posts.PostsService
import com.maruchin.kmm.architecture.sharedlogic.posts.postsModule
import com.maruchin.kmm.architecture.sharedlogic.session.sessionModule
import com.maruchin.kmm.architecture.sharedlogic.users.UsersService
import com.maruchin.kmm.architecture.sharedlogic.users.usersModule
import org.koin.core.KoinApplication
import org.koin.dsl.module

class SharedLibrary(config: SharedConfig) {

    private val koinApplication: KoinApplication

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
