package com.maruchin.kmm.architecture.sharedlogic.posts

import com.maruchin.kmm.architecture.sharedlogic.posts.api.PostsApi
import com.maruchin.kmm.architecture.sharedlogic.posts.data.PostsRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

internal val postsModule = module {
    singleOf(::PostsService)
    singleOf(::PostsRepository)
    singleOf(::PostsApi)
}
