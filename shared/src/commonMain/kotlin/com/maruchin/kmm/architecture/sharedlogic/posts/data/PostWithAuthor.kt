package com.maruchin.kmm.architecture.sharedlogic.posts.data

import com.maruchin.kmm.architecture.sharedlogic.users.data.User

data class PostWithAuthor(val post: Post, val author: User)
