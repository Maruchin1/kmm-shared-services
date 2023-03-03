package com.maruchin.kmm.sharedservices.posts

import com.maruchin.kmm.sharedservices.posts.api.PostsApi
import com.maruchin.kmm.sharedservices.posts.data.PostsRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

internal val postsModule = module {
    singleOf(::PostsService)
    singleOf(::PostsRepository)
    singleOf(::PostsApi)
}
