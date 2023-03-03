package com.maruchin.kmm.architecture.sharedlogic.posts.api

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

internal class PostsApi(private val client: HttpClient) {

    suspend fun fetchAllPosts(): List<PostJson> {
        return client.get("https://jsonplaceholder.typicode.com/posts").body()
    }
}
