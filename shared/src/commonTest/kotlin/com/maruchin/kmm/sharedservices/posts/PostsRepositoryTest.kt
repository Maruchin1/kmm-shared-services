package com.maruchin.kmm.sharedservices.posts

import com.maruchin.kmm.sharedservices.sampleFreshPosts
import com.maruchin.kmm.sharedservices.sampleFreshPostsJson
import com.maruchin.kmm.sharedservices.samplePosts
import com.maruchin.kmm.sharedservices.testModule
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
    private val fakePostsApi: FakePostsApi by inject()
    private val postsRepository: PostsRepository by inject()

    @BeforeTest
    fun before() {
        startKoin { modules(postsModule, testModule) }
    }

    @AfterTest
    fun after() {
        stopKoin()
    }

    @Test
    fun `Get all posts without refreshing`() = runTest {
        // when
        val posts = postsRepository.getAllPosts()
        val freshPosts = postsRepository.getAllPosts()

        // then
        assertContentEquals(samplePosts, posts)
        assertContentEquals(samplePosts, freshPosts)
    }

    @Test
    fun `Get all posts with refresh`() = runTest {
        // when
        val posts = postsRepository.getAllPosts()
        fakePostsApi.allPosts = sampleFreshPostsJson
        val freshPosts = postsRepository.getAllPosts(fresh = true)

        // then
        assertContentEquals(samplePosts, posts)
        assertContentEquals(sampleFreshPosts, freshPosts)
    }
}
