package com.maruchin.kmm.sharedservices.posts.data

import com.maruchin.kmm.sharedservices.mock.HttpMock
import com.maruchin.kmm.sharedservices.libs.libsModule
import com.maruchin.kmm.sharedservices.mock.mocksModule
import com.maruchin.kmm.sharedservices.posts.postsModule
import com.maruchin.kmm.sharedservices.sampleFreshPosts
import com.maruchin.kmm.sharedservices.sampleFreshPostsJson
import com.maruchin.kmm.sharedservices.samplePosts
import com.maruchin.kmm.sharedservices.samplePostsJson
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertContentEquals

@OptIn(ExperimentalCoroutinesApi::class)
internal class PostsRepositoryTest : KoinTest {

    private val httpMock: HttpMock by inject()
    private val postsRepository: PostsRepository by inject()

    @BeforeTest
    fun before() {
        startKoin { modules(libsModule, postsModule, mocksModule) }
    }

    @AfterTest
    fun after() {
        stopKoin()
    }

    @Test
    fun `Get all posts without refreshing`() = runTest {
        httpMock.mockAllPosts(samplePostsJson)
        val posts = postsRepository.getAllPosts()
        val freshPosts = postsRepository.getAllPosts()

        assertContentEquals(samplePosts, posts)
        assertContentEquals(samplePosts, freshPosts)
    }

    @Test
    fun `Get all posts with refresh`() = runTest {
        httpMock.mockAllPosts(samplePostsJson)
        val posts = postsRepository.getAllPosts()
        httpMock.mockAllPosts(sampleFreshPostsJson)
        val freshPosts = postsRepository.getAllPosts(fresh = true)

        assertContentEquals(samplePosts, posts)
        assertContentEquals(sampleFreshPosts, freshPosts)
    }
}
