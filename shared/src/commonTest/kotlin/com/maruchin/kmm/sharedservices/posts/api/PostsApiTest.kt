package com.maruchin.kmm.sharedservices.posts.api

import com.maruchin.kmm.sharedservices.mock.HttpMock
import com.maruchin.kmm.sharedservices.libs.libsModule
import com.maruchin.kmm.sharedservices.mock.mocksModule
import com.maruchin.kmm.sharedservices.posts.postsModule
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

    private val httpMock: HttpMock by inject()
    private val postApi: PostsApi by inject()

    @BeforeTest
    fun before() {
        startKoin {
            modules(libsModule, postsModule, mocksModule)
        }
    }

    @AfterTest
    fun after() {
        stopKoin()
    }

    @Test
    fun `Fetch all posts`() = runTest {
        httpMock.mockAllPosts(samplePostsJson)
        val postsJson = postApi.fetchAllPosts()

        assertContentEquals(samplePostsJson, postsJson)
    }
}
