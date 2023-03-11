package com.maruchin.kmm.sharedservices.posts

import com.maruchin.kmm.sharedservices.samplePostsJson

internal class FakePostsApi : PostsApi {

    var allPosts: List<PostJson> = samplePostsJson

    override suspend fun fetchAllPosts(): List<PostJson> {
        return allPosts
    }
}
