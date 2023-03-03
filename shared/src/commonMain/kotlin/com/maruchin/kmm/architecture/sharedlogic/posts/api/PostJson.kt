package com.maruchin.kmm.architecture.sharedlogic.posts.api

import com.maruchin.kmm.architecture.sharedlogic.posts.data.Post
import kotlinx.serialization.Serializable

@Serializable
internal data class PostJson(val id: Long, val userId: Long, val title: String, val body: String)

internal fun PostJson.asModel() = Post(id = id, userId = userId, title = title, body = body)

internal fun Post.asJson() = PostJson(id = id, userId = userId, title = title, body = body)
