package com.maruchin.kmm.architecture.sharedlogic.posts.data

data class Post(
    val id: Long,
    val userId: Long,
    val title: String,
    val body: String,
)
