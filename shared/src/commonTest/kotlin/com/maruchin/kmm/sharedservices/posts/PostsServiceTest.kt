package com.maruchin.kmm.sharedservices.posts

import com.maruchin.kmm.sharedservices.core.FakeHttpEngine
import com.maruchin.kmm.sharedservices.core.coreModule
import com.maruchin.kmm.sharedservices.core.fakeCoreDependenciesModule
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
    private val fakeHttpEngine: FakeHttpEngine by inject()
    private val postsService: PostsService by inject()

    @BeforeTest
    fun before() {
        startKoin {
            modules(
                postsModule,
                usersModule,
                sessionModule,
                fakeCoreDependenciesModule,
                coreModule
            )
        }
    }

    @AfterTest
    fun after() {
        stopKoin()
    }

    @Test
    fun `Get posts with authors`() = runTest {
        fakeHttpEngine.mockUserByEmail(sampleUsersJson[0])
        fakeHttpEngine.mockUser(sampleUsersJson[0])
        fakeHttpEngine.mockUser(sampleUsersJson[1])
        fakeHttpEngine.mockUser(sampleUsersJson[2])
        fakeHttpEngine.mockAllPosts(samplePostsJson)
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
