package com.maruchin.kmm.sharedservices.posts

import com.maruchin.kmm.sharedservices.samplePostsWithAuthors
import com.maruchin.kmm.sharedservices.session.sessionModule
import com.maruchin.kmm.sharedservices.testModule
import com.maruchin.kmm.sharedservices.users.usersModule
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
class PostsServiceTest : KoinTest {
    private val postsService: PostsService by inject()

    @BeforeTest
    fun before() {
        startKoin { modules(postsModule, usersModule, sessionModule, testModule) }
    }

    @AfterTest
    fun after() {
        stopKoin()
    }

    @Test
    fun `Get posts with authors`() = runTest {
        // when
        val postsWithAuthors = postsService.getPostsWithAuthors()

        // then
        assertContentEquals(samplePostsWithAuthors, postsWithAuthors)
    }
}
