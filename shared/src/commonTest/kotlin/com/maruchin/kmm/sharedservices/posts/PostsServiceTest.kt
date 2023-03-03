package com.maruchin.kmm.sharedservices.posts

import com.maruchin.kmm.sharedservices.libs.libsModule
import com.maruchin.kmm.sharedservices.mock.HttpMock
import com.maruchin.kmm.sharedservices.mock.mocksModule
import com.maruchin.kmm.sharedservices.posts.data.PostWithAuthor
import com.maruchin.kmm.sharedservices.samplePosts
import com.maruchin.kmm.sharedservices.samplePostsJson
import com.maruchin.kmm.sharedservices.sampleUsers
import com.maruchin.kmm.sharedservices.sampleUsersJson
import com.maruchin.kmm.sharedservices.session.sessionModule
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
    private val httpMock: HttpMock by inject()
    private val postsService: PostsService by inject()

    @BeforeTest
    fun before() {
        startKoin { modules(libsModule, postsModule, usersModule, sessionModule, mocksModule) }
    }

    @AfterTest
    fun after() {
        stopKoin()
    }

    @Test
    fun `Get posts with authors`() = runTest {
        httpMock.mockUserByEmail(sampleUsersJson[0])
        httpMock.mockUser(sampleUsersJson[0])
        httpMock.mockUser(sampleUsersJson[1])
        httpMock.mockUser(sampleUsersJson[2])
        httpMock.mockAllPosts(samplePostsJson)
        val postsWithAuthors = postsService.getPostsWithAuthors()

        assertContentEquals(
            listOf(
                PostWithAuthor(samplePosts[0], sampleUsers[0]),
                PostWithAuthor(samplePosts[1], sampleUsers[1]),
                PostWithAuthor(samplePosts[2], sampleUsers[2]),
            ),
            postsWithAuthors,
        )
    }
}
