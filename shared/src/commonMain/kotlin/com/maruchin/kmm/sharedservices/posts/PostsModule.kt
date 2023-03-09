package com.maruchin.kmm.sharedservices.posts

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

internal val postsModule = module {
    singleOf(::PostsService)
    singleOf(::PostsRepository)
    singleOf(::PostsApi)
}
