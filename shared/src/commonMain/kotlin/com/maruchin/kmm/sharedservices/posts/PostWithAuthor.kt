package com.maruchin.kmm.sharedservices.posts

import com.maruchin.kmm.sharedservices.users.User

data class PostWithAuthor(val post: Post, val author: User)
