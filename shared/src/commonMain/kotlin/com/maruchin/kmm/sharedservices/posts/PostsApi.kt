package com.maruchin.kmm.sharedservices.posts

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

internal class PostsApi(private val client: HttpClient) {

    suspend fun fetchAllPosts(): List<PostJson> {
        return client.get("https://jsonplaceholder.typicode.com/posts").body()
    }
}
