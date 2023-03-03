package com.maruchin.kmm.architecture.sharedlogic.posts

import com.maruchin.kmm.architecture.sharedlogic.posts.data.PostsRepository
import com.maruchin.kmm.architecture.sharedlogic.posts.data.PostWithAuthor
import com.maruchin.kmm.architecture.sharedlogic.users.data.UsersRepository

class PostsService internal constructor(
    private val postsRepository: PostsRepository,
    private val usersRepository: UsersRepository,
) {

    @Throws(Exception::class)
    suspend fun getPostsWithUsers(): List<PostWithAuthor> {
        return postsRepository.getAllPosts().mapNotNull { post ->
            usersRepository.getUser(post.userId)?.let { user ->
                PostWithAuthor(post, user)
            }
        }
    }
}
