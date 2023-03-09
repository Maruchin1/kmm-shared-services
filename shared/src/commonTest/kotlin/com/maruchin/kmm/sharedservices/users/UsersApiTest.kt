package com.maruchin.kmm.sharedservices.users

import com.maruchin.kmm.sharedservices.core.FakeHttpEngine
import com.maruchin.kmm.sharedservices.core.coreModule
import com.maruchin.kmm.sharedservices.core.fakeCoreDependenciesModule
import com.maruchin.kmm.sharedservices.sampleUsersJson
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
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class UsersApiTest : KoinTest {
    private val fakeHttpEngine: FakeHttpEngine by inject()
    private val usersApi: UsersApi by inject()

    @BeforeTest
    fun before() {
        startKoin { modules(usersModule, fakeCoreDependenciesModule, coreModule) }
    }

    @AfterTest
    fun after() {
        stopKoin()
    }

    @Test
    fun `Fetch user`() = runTest {
        fakeHttpEngine.mockUser(sampleUsersJson[1])
        val user = usersApi.fetchUser(sampleUsersJson[1].id)

        assertEquals(sampleUsersJson[1], user)
    }

    @Test
    fun `Fetch user by email`() = runTest {
        fakeHttpEngine.mockUserByEmail(sampleUsersJson[2])
        val user = usersApi.fetchUserByEmail(sampleUsersJson[2].email)

        assertContentEquals(listOf(sampleUsersJson[2]), user)
    }
}
