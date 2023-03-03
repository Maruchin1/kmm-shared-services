package com.maruchin.kmm.sharedservices.posts.data

data class Post(
    val id: Long,
    val userId: Long,
    val title: String,
    val body: String,
)
