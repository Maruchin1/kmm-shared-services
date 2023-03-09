package com.maruchin.kmm.sharedservices.posts

import com.maruchin.kmm.sharedservices.core.FakeHttpEngine
import com.maruchin.kmm.sharedservices.core.coreModule
import com.maruchin.kmm.sharedservices.core.fakeCoreDependenciesModule
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
internal class PostsApiTest : KoinTest {
    private val fakeHttpEngine: FakeHttpEngine by inject()
    private val postApi: PostsApi by inject()

    @BeforeTest
    fun before() {
        startKoin {
            modules(postsModule,  fakeCoreDependenciesModule, coreModule)
        }
    }

    @AfterTest
    fun after() {
        stopKoin()
    }

    @Test
    fun `Fetch all posts`() = runTest {
        fakeHttpEngine.mockAllPosts(samplePostsJson)
        val postsJson = postApi.fetchAllPosts()

        assertContentEquals(samplePostsJson, postsJson)
    }
}
