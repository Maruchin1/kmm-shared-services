package com.maruchin.kmm.sharedservices.posts

import com.maruchin.kmm.sharedservices.core.FakeHttpEngine
import com.maruchin.kmm.sharedservices.core.coreModule
import com.maruchin.kmm.sharedservices.core.fakeCoreDependenciesModule
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
    private val fakeHttpEngine: FakeHttpEngine by inject()
    private val postsRepository: PostsRepository by inject()

    @BeforeTest
    fun before() {
        startKoin { modules(postsModule, fakeCoreDependenciesModule, coreModule) }
    }

    @AfterTest
    fun after() {
        stopKoin()
    }

    @Test
    fun `Get all posts without refreshing`() = runTest {
        fakeHttpEngine.mockAllPosts(samplePostsJson)
        val posts = postsRepository.getAllPosts()
        val freshPosts = postsRepository.getAllPosts()

        assertContentEquals(samplePosts, posts)
        assertContentEquals(samplePosts, freshPosts)
    }

    @Test
    fun `Get all posts with refresh`() = runTest {
        fakeHttpEngine.mockAllPosts(samplePostsJson)
        val posts = postsRepository.getAllPosts()
        fakeHttpEngine.mockAllPosts(sampleFreshPostsJson)
        val freshPosts = postsRepository.getAllPosts(fresh = true)

        assertContentEquals(samplePosts, posts)
        assertContentEquals(sampleFreshPosts, freshPosts)
    }
}
