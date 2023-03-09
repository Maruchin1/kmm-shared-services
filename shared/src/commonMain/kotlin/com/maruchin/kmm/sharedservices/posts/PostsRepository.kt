package com.maruchin.kmm.sharedservices.posts

import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

internal class PostsRepository(private val postsApi: PostsApi) : Mutex by Mutex() {

    private var posts: List<Post> = emptyList()

    suspend fun getAllPosts(fresh: Boolean = false): List<Post> {
        if (fresh || posts.isEmpty()) {
            val apiPosts = postsApi.fetchAllPosts().map { it.asModel() }
            withLock { posts = apiPosts }
        }
        return posts
    }
}
