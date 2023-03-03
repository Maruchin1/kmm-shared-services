package com.maruchin.kmm.sharedservices.posts.data

import com.maruchin.kmm.sharedservices.users.data.User

data class PostWithAuthor(val post: Post, val author: User)
