package com.maruchin.kmm.sharedservices.posts

import com.maruchin.kmm.sharedservices.posts.data.PostsRepository
import com.maruchin.kmm.sharedservices.posts.data.PostWithAuthor
import com.maruchin.kmm.sharedservices.users.data.UsersRepository

class PostsService internal constructor(
    private val postsRepository: PostsRepository,
    private val usersRepository: UsersRepository,
) {

    @Throws(Exception::class)
    suspend fun getPostsWithAuthors(): List<PostWithAuthor> {
        return postsRepository.getAllPosts().mapNotNull { post ->
            usersRepository.getUser(post.userId)?.let { user ->
                PostWithAuthor(post, user)
            }
        }
    }
}
