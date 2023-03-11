package com.maruchin.kmm.sharedservices.posts

internal interface PostsApi {
    suspend fun fetchAllPosts(): List<PostJson>
}
